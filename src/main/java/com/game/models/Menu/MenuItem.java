package com.game.models.Menu;

import java.util.ArrayList;

public class MenuItem {
    private final String title;
    private final MenuItemsEnum menuItemValue;

    MenuItem(String title, MenuItemsEnum menuItemValue) {
        this.title = title;
        this.menuItemValue = menuItemValue;
    }

    public String getTitle() {
        return title;
    }

    public MenuItemsEnum getMenuItemValue() {
        return menuItemValue;
    }

    public static ArrayList<MenuItem> getItemsForMainMenu() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Game with human", MenuItemsEnum.GAME_WITH_HUMAN));
        menuItems.add(new MenuItem("Game with AI (easy)", MenuItemsEnum.GAME_WITH_AI_EASY));
        menuItems.add(new MenuItem("Game with AI (hard)", MenuItemsEnum.GAME_WITH_AI_HARD));
        menuItems.add(new MenuItem("Exit", MenuItemsEnum.EXIT));
        return menuItems;
    }
}
