package com.game.models;

import com.game.models.Field.Field;
import com.game.models.GameInterface.GameInterface;
import com.game.models.Menu.MainMenu;
import com.game.models.Players.Player;

public class Game {
    private GameInterface gameInterface;
    private GameStage stage;
    private MainMenu mainMenu;
    private Field field;
    private Player player1;
    private Player player2;

    public Game(GameInterface gameInterface) {
        this.gameInterface = gameInterface;
        this.stage = GameStage.MAIN_MENU;
        this.mainMenu = new MainMenu(this.stage);
        this.field = null;

        gameInterface.setMenu(mainMenu);
    }

    public void gameProcess() {
        Boolean isGameRunning = true;
        while (isGameRunning) {
            switch (stage) {
                case MAIN_MENU:
                    stage = gameInterface.menuLogic();
                    break;
                case GAME_WITH_HUMAN:
                    break;
                case GAME_WITH_AI_EASY:
                    break;
                case EXIT:
                    isGameRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}
