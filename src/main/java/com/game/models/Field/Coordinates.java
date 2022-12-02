package com.game.models.Field;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates add(Coordinates direction) {
        return new Coordinates(x + direction.getX(), y + direction.getY());
    }
}
