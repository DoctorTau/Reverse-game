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

    private void setStartPosition() {
        field.get(3).get(3).setValue(CellValue.WHITE);
        field.get(4).get(4).setValue(CellValue.WHITE);
        field.get(3).get(4).setValue(CellValue.BLACK);
        field.get(4).get(3).setValue(CellValue.BLACK);
    }
}
