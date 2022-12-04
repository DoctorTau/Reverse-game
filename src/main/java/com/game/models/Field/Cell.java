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

    public Cell clone() {
        return new Cell(coordinates.getX(), coordinates.getY(), value);
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cell other = (Cell) obj;
        if (coordinates == null) {
            if (other.coordinates != null)
                return false;
        } else if (!coordinates.equals(other.coordinates))
            return false;
        if (value != other.value)
            return false;
        return true;
    }
}
