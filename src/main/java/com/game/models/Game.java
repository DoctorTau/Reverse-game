package com.game.models;

import com.game.models.Field.CellValue;
import com.game.models.Field.Field;
import com.game.models.GameInterface.ConsoleInterface;
import com.game.models.GameInterface.GameInterface;
import com.game.models.Menu.MainMenu;
import com.game.models.Players.AIPlayerEasy;
import com.game.models.Players.HumanPlayer;
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
                    field = new Field(8);
                    player1 = new HumanPlayer(CellValue.BLACK, field);
                    player2 = new HumanPlayer(CellValue.WHITE, field);
                    break;
                case GAME_WITH_AI_EASY:
                    field = new Field(8);
                    player1 = new HumanPlayer(CellValue.BLACK, field);
                    player2 = new AIPlayerEasy(CellValue.WHITE, field);
                    gameInterface.setField(field);
                    while (true) {
                        field.markPossibleMoves(player1.getColor());
                        gameInterface.showField();
                        gameInterface.makeTurn(player1);
                        if (field.isGameOver()) {
                            break;
                        }
                        field.markPossibleMoves(player2.getColor());
                        gameInterface.showField();
                        gameInterface.makeTurn(player2);
                        if (field.isGameOver()) {
                            break;
                        }
                    }
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
