package com.game.models.Output;

import java.util.ArrayList;

import com.game.models.Field.Cell;
import com.game.models.Field.CellValue;
import com.game.models.Field.Field;
import com.game.models.GameInterface.ConsoleInterface;
import com.game.models.Menu.MainMenu;
import com.game.models.Menu.MenuItem;

public class ConsoleOutput implements IGameOutput {

    @Override
    public void fieldOutput(Field field) {
        String fieldString = getFieldString(field);
        ConsoleInterface.clearConsole();
        System.out.println(fieldString);
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
        ConsoleInterface.clearConsole();
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

    @Override
    public void gameScoreOutput(Field field) {
        int blackScore = field.getPlayersScore(CellValue.BLACK);
        int whiteScore = field.getPlayersScore(CellValue.WHITE);
        String result = "Black score: " + blackScore + "\n" + "White score: " + whiteScore + "\n";
        System.out.println(result);
    }
}
