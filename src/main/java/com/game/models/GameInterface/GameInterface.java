package com.game.models.GameInterface;

import com.game.models.GameStage;
import com.game.models.Field.Field;
import com.game.models.Input.IGameInput;
import com.game.models.Output.IGameOutput;
import com.game.models.Players.Player;

public abstract class GameInterface {
    protected Field field;
    protected IGameInput input;
    protected IGameOutput output;

    public GameInterface(Field field, IGameInput input, IGameOutput output) {
        this.field = field;
        this.input = input;
        this.output = output;
    }

    abstract public GameStage menuLogic();

    abstract public void startGame();

    abstract public void endGame();

    abstract public void makeTurn(Player player);
}
