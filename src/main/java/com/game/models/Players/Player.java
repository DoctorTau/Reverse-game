package com.game.models.Players;

import com.game.models.Field.Cell;
import com.game.models.Field.CellValue;
import com.game.models.Field.Field;
import com.game.models.Input.IInputer;

public abstract class Player {
    protected CellValue color;
    protected Field field;

    public Player(CellValue color, Field field) {
        this.color = color;
        this.field = field;
    }

    abstract public Cell makeMove(Field field, IInputer input);
}
