package com.game.models.Output;

import com.game.models.Field.Cell;
import com.game.models.Field.Field;

public class ConsoleOutputter implements IOutputer {

    @Override
    public void fieldOutput(Field field) {
        String fieldString = getFieldString(field);
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
}
