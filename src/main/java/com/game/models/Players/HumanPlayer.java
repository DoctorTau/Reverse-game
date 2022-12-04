package com.game.models.Players;

import com.game.models.Field.Cell;
import com.game.models.Field.CellValue;
import com.game.models.Field.Coordinates;
import com.game.models.Field.Field;
import com.game.models.Input.IGameInput;

public class HumanPlayer extends Player {

    public HumanPlayer(CellValue color, Field field) {
        super(color, field);
    }

    @Override
    public Cell makeMove(Field field, IGameInput input) {
        Coordinates cellCoordinates = input.getCell();
        Cell cell = new Cell(cellCoordinates.getX(), cellCoordinates.getY(), color);

        return cell;
    }
}
