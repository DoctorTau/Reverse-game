package com.game.models.Menu;

import com.game.models.GameStage;

public class MainMenu {
    private GameStage stage;
    private final String[] menuItems = {
            "Game with human",
            "Game with AI (easy)",
            "Game with AI (hard)",
            "Exit"
    };

    public MainMenu(GameStage stage) {
        this.stage = stage;
    }

    public String[] getMenuitems() {
        return menuItems;
    }

    public GameStage getStage() {
        return stage;
    }

    public void setStage(GameStage stage) {
        this.stage = stage;
    }
}
