package com.game.models;

public class Cell {
    private CellValue value;

    public Cell() {
        value = CellValue.EMPTY;
    }

    public CellValue getValue() {
        return value;
    }

    public void setValue(CellValue value) {
        this.value = value;
    }
}
