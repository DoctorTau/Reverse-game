package com.game;

import com.game.models.Game;
import com.game.models.GameInterface.ConsoleInterface;

public class App {
    public static void main(String[] args) {
        Game game = new Game(new ConsoleInterface());

        game.gameProcess();
    }
}
