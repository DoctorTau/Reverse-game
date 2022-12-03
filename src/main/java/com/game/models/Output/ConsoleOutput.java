package com.game.models.Output;

import java.util.ArrayList;

import com.game.models.Field.Cell;
import com.game.models.Field.Field;
import com.game.models.Menu.MainMenu;
import com.game.models.Menu.MenuItem;

public class ConsoleOutput implements IOutputer {

    @Override
    public void fieldOutput(Field field) {
        String fieldString = getFieldString(field);
        clearConsole();
        System.out.println(fieldString);
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String getFieldString(Field field) {
        String result = "";
        for (int i = 0; i < field.getSize(); i++) {
            result += (i + 1) + "";
            for (int j = 0; j < field.getSize(); j++) {
                Cell cell = field.getCell(i, j);
                result += getCellString(cell);
            }
            result += "|\n";
        }
        result += makeLettersLine();
        return result;
    }

    private String makeLettersLine() {
        String result = " |a|b|c|d|e|f|g|h|\n";
        return result;
    }

    private String getCellString(Cell cell) {
        String result = "|";
        switch (cell.getValue()) {
            case BLACK:
                result += "B";
                break;
            case WHITE:
                result += "W";
                break;
            case POSSIBLE_MOVE:
                result += "*";
                break;
            case EMPTY:
                result += " ";
                break;
        }
        return result;
    }

    @Override
    public void menuOutput(MainMenu menu) {
        String result = getMenuAsString(menu);
        System.out.println(result);
    }

    public String getMenuAsString(MainMenu menu) {
        ArrayList<MenuItem> menuItems = menu.getMenuItems();
        String result = "";
        for (int i = 0; i < menuItems.size(); i++) {
            result += (i + 1) + ". " + menuItems.get(i).getTitle() + "\n";
        }
        return result;
    }
}
