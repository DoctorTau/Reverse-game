package com.game.models;

public abstract class Player {
    private CellValue color;
    private Field field;

    public Player(CellValue color, Field field) {
        this.color = color;
        this.field = field;
    }

    abstract public Cell makeMove(Field field);
}
