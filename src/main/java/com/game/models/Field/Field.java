package com.game.models.Field;

import java.util.ArrayList;

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

    private Boolean recolorIfNeeded(Coordinates currentCoordinates, Coordinates direction, CellValue color) {
        if (currentCoordinates.getX() < 0 || currentCoordinates.getX() > 7 || currentCoordinates.getY() < 0
                || currentCoordinates.getY() > 7) {
            return false;
        }
        Cell cell = getCell(currentCoordinates.getX(), currentCoordinates.getY());
        if (cell.getValue() != CellValue.BLACK && cell.getValue() != CellValue.WHITE) {
            return false;
        }

        if (cell.getValue() != color) {
            cell.setValue(color);
            return true;
        }
        Coordinates nextCoordinates = currentCoordinates.add(direction);
        if (recolorIfNeeded(nextCoordinates, direction, color)) {
            cell.setValue(color);
            return true;
        }
        return false;
    }

    private void setStartPosition() {
        field.get(3).get(3).setValue(CellValue.WHITE);
        field.get(4).get(4).setValue(CellValue.WHITE);
        field.get(3).get(4).setValue(CellValue.BLACK);
        field.get(4).get(3).setValue(CellValue.BLACK);
    }
}
