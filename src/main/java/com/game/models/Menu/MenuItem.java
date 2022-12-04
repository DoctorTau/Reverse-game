package com.game.models.Menu;

import java.util.ArrayList;

import com.game.models.GameStage;

public class MenuItem {
    private final String title;
    private final GameStage value;

    MenuItem(String title, GameStage menuItemValue) {
        this.title = title;
        this.value = menuItemValue;
    }

    public String getTitle() {
        return title;
    }

    public GameStage getMenuItemValue() {
        return value;
    }

    public static ArrayList<MenuItem> getItemsForMainMenu() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Game with human", GameStage.GAME_WITH_HUMAN));
        menuItems.add(new MenuItem("Game with AI (easy)", GameStage.GAME_WITH_AI_EASY));
        menuItems.add(new MenuItem("Exit", GameStage.EXIT));
        return menuItems;
    }
}
