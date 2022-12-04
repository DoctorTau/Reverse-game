package com.game.models.Input;

import com.game.models.GameStage;
import com.game.models.Field.Cell;
import com.game.models.Field.Coordinates;
import com.game.models.Field.Field;
import com.game.models.Menu.MainMenu;

public interface IGameInput {
    Cell getCell(Field field);

    GameStage getMenuOption(MainMenu menu);

    Boolean CheckInput(Coordinates cell, Field field);

    void backToMenu();
}
