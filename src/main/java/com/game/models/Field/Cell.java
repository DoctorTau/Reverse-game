package com.game.models.Field;

public class Cell {
    Coordinates coordinates;
    private CellValue value;

    public Cell(int xCoordinate, int yCoordinate) {
        coordinates = new Coordinates(xCoordinate, yCoordinate);
        value = CellValue.EMPTY;
    }

    public Cell(int xCoordinate, int yCoordinate, CellValue value) {
        coordinates = new Coordinates(xCoordinate, yCoordinate);
        this.value = value;
    }

    public CellValue getValue() {
        return value;
    }

    public void setValue(CellValue value) {
        this.value = value;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getXCoordinate() {
        return coordinates.getX();
    }

    public int getYCoordinate() {
        return coordinates.getY();
    }
}
