package com.game.models.GameInterface;

import com.game.models.GameStage;
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
    public void startGame() {
        // TODO Auto-generated method stub

    }

    @Override
    public void endGame() {
        // TODO Auto-generated method stub

    }

    @Override
    public void makeTurn(Player player) {
        // TODO Auto-generated method stub

    }

}
