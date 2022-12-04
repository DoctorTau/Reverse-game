package com.game.models.Players;

import com.game.models.Field.Cell;
import com.game.models.Field.CellValue;
import com.game.models.Field.Field;
import com.game.models.Input.IGameInput;

public abstract class Player {
    protected CellValue color;
    protected Field field;
    protected int score;

    public Player(CellValue color, Field field) {
        this.color = color;
        this.field = field;
    }

    abstract public Cell makeMove(Field field, IGameInput input);

    public CellValue getColor() {
        return color;
    }

    public void setColor(CellValue color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
