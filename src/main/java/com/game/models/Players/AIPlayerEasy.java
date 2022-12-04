package com.game.models.Players;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.game.models.Field.Cell;
import com.game.models.Field.CellCost;
import com.game.models.Field.CellValue;
import com.game.models.Field.Field;
import com.game.models.Input.IGameInput;

public class AIPlayerEasy extends Player {

    public AIPlayerEasy(CellValue color, Field field) {
        super(color, field);
    }

    private static double CellCostToScoreRecolored(CellCost cellCost) {
        if (cellCost == CellCost.ANGLE || cellCost == CellCost.BORDER) {
            return 2;
        }
        return 1;
    }

    private static double CellCostToScoreRegular(CellCost cellCost) {
        if (cellCost == CellCost.ANGLE) {
            return 0.8;
        }
        if (cellCost == CellCost.BORDER) {
            return 0.4;
        }
        return 0;
    }

    @Override
    public Cell makeMove(Field field, IGameInput input) {
        Set<Cell> possibleMoves = field.getCellsForNextMove();
        Map<Cell, Double> possibleMovesWithScores = new HashMap<Cell, Double>();
        for (Cell cell : possibleMoves) {
            possibleMovesWithScores.put(cell, getScoreForCell(cell, field));
        }

        Cell maxScoreCell = null;
        double maxScore = 0;
        for (Cell cell : possibleMovesWithScores.keySet()) {
            if (possibleMovesWithScores.get(cell) > maxScore) {
                maxScore = possibleMovesWithScores.get(cell);
                maxScoreCell = cell;
            }
        }
        return maxScoreCell;
    }

    private double getScoreForCell(Cell cell, Field field) {
        double score = CellCostToScoreRegular(field.getCellCost(cell));
        Set<Cell> recoloredCells = field.getPossiblyRecoloredCells(cell.getCoordinates(), color);
        for (Cell recoloredCell : recoloredCells) {
            score += CellCostToScoreRecolored(field.getCellCost(recoloredCell));
        }
        return score;
    }

}
