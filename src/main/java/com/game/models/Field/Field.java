package com.game.models.Field;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Field {
    int size;

    ArrayList<ArrayList<Cell>> field;

    public Field(int size) {
        this.size = size;
        field = new ArrayList<ArrayList<Cell>>();
        for (int i = 0; i < size; i++) {
            field.add(new ArrayList<Cell>());
            for (int j = 0; j < size; j++) {
                field.get(i).add(new Cell(i, j));
            }
        }

        setStartPosition();
    }

    public int getSize() {
        return size;
    }

    public ArrayList<ArrayList<Cell>> getField() {
        return field;
    }

    public Cell getCell(int x, int y) {
        return field.get(x).get(y);
    }

    public void setValue(int x, int y, CellValue value) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new IllegalArgumentException("Invalid coordinates!");
        }
        if (value == CellValue.EMPTY) {
            throw new IllegalArgumentException("Invalid value!");
        }
        if (field.get(x).get(y).getValue() != CellValue.EMPTY
                && field.get(x).get(y).getValue() != CellValue.POSSIBLE_MOVE) {
            throw new IllegalArgumentException("Cell is not empty!");
        }
        if ((value == CellValue.BLACK
                || value == CellValue.WHITE) && field.get(x).get(y).getValue() == CellValue.POSSIBLE_MOVE) {
            field.get(x).get(y).setValue(value);
        }
        field.get(x).get(y).setValue(value);
    }

    public static CellValue getOppositeCellValue(CellValue value) {
        if (value == CellValue.BLACK) {
            return CellValue.WHITE;
        } else if (value == CellValue.WHITE) {
            return CellValue.BLACK;
        } else {
            throw new IllegalArgumentException("Invalid value!");
        }
    }

    public Set<Cell> getCellsForNextMove(CellValue value) {
        CellValue oppositeCellValue = getOppositeCellValue(value);
        Set<Cell> result = new HashSet<Cell>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = field.get(i).get(j);
                if (cell.getValue() == oppositeCellValue) {
                    Set<Cell> cellSurroundings = getCellSurroundings(cell);
                    leaveOnlyEmptyCells(cellSurroundings);
                    leaveOnlyChangeColorCells(oppositeCellValue, cell, cellSurroundings);
                    result.addAll(cellSurroundings);
                }
            }
        }
        return result;
    }

    private void leaveOnlyChangeColorCells(CellValue oppositeCellValue, Cell cell, Set<Cell> cellSurroundings) {
        Set<Cell> cellsToRemove = new HashSet<Cell>();
        for (Cell cellSurround : cellSurroundings) {
            Coordinates cellSurroundCoordinates = cellSurround.getCoordinates();
            Coordinates direction = cell.getCoordinates().subtract(cellSurroundCoordinates);
            if (!checkIfCellCanBeChanged(cell.getCoordinates(), direction, oppositeCellValue)) {
                cellsToRemove.add(cellSurround);
            }
        }
        cellSurroundings.removeAll(cellsToRemove);
    }

    private void leaveOnlyEmptyCells(Set<Cell> result) {
        Set<Cell> cellsToRemove = new HashSet<Cell>();
        for (Cell cell : result) {
            if (cell.getValue() != CellValue.EMPTY) {
                cellsToRemove.add(cell);
            }
        }
        result.removeAll(cellsToRemove);
    }

    private Set<Cell> getCellSurroundings(Cell cell) {
        Coordinates cellCoordinates = cell.getCoordinates();
        Set<Cell> result = new HashSet<Cell>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int x = cellCoordinates.getX() + i;
                int y = cellCoordinates.getY() + j;
                if (x >= 0 && x < size && y >= 0 && y < size) {
                    result.add(field.get(x).get(y));
                }
            }
        }

        return result;
    }

    public void updateFieldAfterMove(Cell newCell) {
        if (newCell.getValue() != CellValue.BLACK && newCell.getValue() != CellValue.WHITE) {
            throw new IllegalArgumentException("Invalid cell!");
        }
        Coordinates cellCoordinates = newCell.getCoordinates();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                Coordinates direction = new Coordinates(i, j);
                recolorIfNeeded(cellCoordinates.add(direction), direction, newCell.getValue());
            }
        }
    }

    private Cell getColoredCell(Coordinates coordinates) {
        if (coordinates.getX() < 0 || coordinates.getX() > 7 || coordinates.getY() < 0
                || coordinates.getY() > 7) {
            return null;
        }
        Cell cell = getCell(coordinates.getX(), coordinates.getY());
        if (cell.getValue() != CellValue.BLACK && cell.getValue() != CellValue.WHITE) {
            return null;
        }
        return cell;
    }

    private Boolean checkIfCellCanBeChanged(Coordinates currentCoordinates, Coordinates direction, CellValue color) {
        Cell cell = getColoredCell(currentCoordinates);
        if (cell == null) {
            return false;
        }
        if (cell.getValue() != color) {
            return true;
        }
        Coordinates nextCoordinates = currentCoordinates.add(direction);
        return checkIfCellCanBeChanged(nextCoordinates, direction, color);
    }

    private void recolorIfNeeded(Coordinates currentCoordinates, Coordinates direction, CellValue color) {
        Cell cell = getColoredCell(currentCoordinates);
        if (cell == null) {
            return;
        }
        if (checkIfCellCanBeChanged(currentCoordinates, direction, color)) {
            cell.setValue(color);
            Coordinates nextCoordinates = currentCoordinates.add(direction);
            recolorIfNeeded(nextCoordinates, direction, color);
        }
    }

    private void setStartPosition() {
        field.get(3).get(3).setValue(CellValue.WHITE);
        field.get(4).get(4).setValue(CellValue.WHITE);
        field.get(3).get(4).setValue(CellValue.BLACK);
        field.get(4).get(3).setValue(CellValue.BLACK);
    }
}
