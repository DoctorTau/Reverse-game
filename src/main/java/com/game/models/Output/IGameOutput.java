package com.game.models.Output;

import com.game.models.Field.Field;
import com.game.models.Menu.MainMenu;
import com.game.models.Players.Player;

public interface IGameOutput {
    void fieldOutput(Field field);

    void gameScoreOutput(Field field);

    void menuOutput(MainMenu menu);

    void runOutOfMovesOutput(Player player);

    void GameOverOutput(Field field);
}
