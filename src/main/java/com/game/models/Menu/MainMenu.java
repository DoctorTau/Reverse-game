package com.game.models.Menu;

import java.util.ArrayList;

import com.game.models.GameStage;

public class MainMenu {
    private GameStage stage;
    private final ArrayList<MenuItem> menuItems = MenuItem.getItemsForMainMenu();

    public MainMenu(GameStage stage) {
        this.stage = stage;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public GameStage getStage() {
        return stage;
    }

    public void setStage(GameStage stage) {
        this.stage = stage;
    }
}
