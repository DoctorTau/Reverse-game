package com.game.models.Input;

import com.game.models.GameStage;
import com.game.models.Field.Coordinates;
import com.game.models.Menu.MainMenu;

public interface IGameInput {
    Coordinates getCell();

    GameStage getMenuOption(MainMenu menu);

    Boolean CheckInput(Coordinates cell);
}
