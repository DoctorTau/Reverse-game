package com.game.models.Input;

import com.game.models.Field.Coordinates;

public interface IInputer {
    Coordinates getCell();

    Boolean CheckInput(Coordinates cell);
}
