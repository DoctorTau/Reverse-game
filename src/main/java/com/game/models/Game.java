package com.game.models;

import com.game.models.Field.CellValue;
import com.game.models.Field.Field;
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

    private void startGame() {
        this.field = new Field(8);
        gameInterface.setField(field);
    }

    private void gameCycle() {
        while (true) {
            playerMove(player1);
            playerMove(player2);
        }
    }

    private void playerMove(Player player) {
        field.markPossibleMoves(player.getColor());
        if (field.getCellsForNextMove().size() != 0) {
            gameInterface.showField();
            gameInterface.makeTurn(player);
        }
    }

    public void gameProcess() {
        Boolean isGameRunning = true;
        while (isGameRunning) {
            switch (stage) {
                case MAIN_MENU:
                    stage = gameInterface.menuLogic();
                    break;
                case GAME_WITH_HUMAN:
                    startGame();
                    player1 = new HumanPlayer(CellValue.BLACK, field);
                    player2 = new HumanPlayer(CellValue.WHITE, field);
                    gameCycle();
                    break;
                case GAME_WITH_AI_EASY:
                    startGame();
                    player1 = new HumanPlayer(CellValue.BLACK, field);
                    player2 = new AIPlayerEasy(CellValue.WHITE, field);
                    gameCycle();
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
