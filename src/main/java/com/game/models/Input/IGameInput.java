package com.game.models.Input;

import com.game.models.Field.Coordinates;

public interface IGameInput {
    Coordinates getCell();

    Boolean CheckInput(Coordinates cell);
}
