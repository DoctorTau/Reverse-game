package com.game.models.Players;

import com.game.models.Field.Cell;
import com.game.models.Field.CellValue;
import com.game.models.Field.Field;
import com.game.models.Input.IGameInput;

public class AIPlayerEasy extends Player {

    public AIPlayerEasy(CellValue color, Field field) {
        super(color, field);
    }

    @Override
    public Cell makeMove(Field field, IGameInput input) {
        return null;
    }

}
