package com.game.models.Output;

import com.game.models.Field.Field;
import com.game.models.Menu.MainMenu;

public interface IGameOutput {
    void fieldOutput(Field field);

    void gameScoreOutput(Field field);

    void menuOutput(MainMenu menu);
}
