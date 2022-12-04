package com.game.models.GameInterface;

import com.game.models.GameStage;
import com.game.models.Field.Cell;
import com.game.models.Field.Field;
import com.game.models.Input.ConsoleInput;
import com.game.models.Menu.MainMenu;
import com.game.models.Output.ConsoleOutput;
import com.game.models.Players.Player;

public class ConsoleInterface extends GameInterface {

    public ConsoleInterface() {
        super(null, null, new ConsoleInput(), new ConsoleOutput());
    }

    public ConsoleInterface(Field field, MainMenu menu) {
        super(field, menu, new ConsoleInput(), new ConsoleOutput());
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public GameStage menuLogic() {
        output.menuOutput(menu);
        return input.getMenuOption(menu);
    }

    @Override
    public void makeTurn(Player player) {
        Cell cell = player.makeMove(field, input);
        if (cell == null) {
            return;
        }
        cell.setValue(player.getColor());
        field.setCell(cell);
        field.updateFieldAfterMove(cell);
    }

    @Override
    public void showField() {
        output.fieldOutput(field);
        output.gameScoreOutput(field);
    }

    @Override
    public void RunOutOfMoves(Player player) {
        output.runOutOfMovesOutput(player);
    }

    @Override
    public void gameOverOutput() {
        output.GameOverOutput(field);
    }

}
