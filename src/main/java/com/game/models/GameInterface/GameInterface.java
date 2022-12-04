package com.game.models.GameInterface;

import com.game.models.GameStage;
import com.game.models.Field.Field;
import com.game.models.Input.IGameInput;
import com.game.models.Menu.MainMenu;
import com.game.models.Output.IGameOutput;
import com.game.models.Players.Player;

public abstract class GameInterface {
    protected Field field;
    protected MainMenu menu;
    protected IGameInput input;
    protected IGameOutput output;

    public GameInterface(Field field, MainMenu menu, IGameInput input, IGameOutput output) {
        this.field = field;
        this.input = input;
        this.output = output;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setMenu(MainMenu menu) {
        this.menu = menu;
    }

    abstract public void showField();

    abstract public GameStage menuLogic();

    abstract public void startGame();

    abstract public void endGame();

    abstract public void makeTurn(Player player);
}
