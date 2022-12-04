package com.game.models.Input;

import java.util.Scanner;

import com.game.models.GameStage;
import com.game.models.Field.Cell;
import com.game.models.Field.CellValue;
import com.game.models.Field.Coordinates;
import com.game.models.Field.Field;
import com.game.models.Menu.MainMenu;

public class ConsoleInput implements IGameInput {
    private static final String INPUT_CELL_MESSAGE = "Enter cell number: ";
    private static final String INPUT_MENU_MESSAGE = "Enter menu option number: ";
    private static final String INCORRECT_CELL_INPUT_MESSAGE = "Entered cell number is incorrect. Try again: ";
    private static final String INCORRECT_MENU_INPUT_MESSAGE = "Entered menu option is incorrect. Try again: ";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Cell getCell(Field field) {
        System.out.print(INPUT_CELL_MESSAGE);
        Boolean isCorrectInput = false;
        Coordinates cellCoordinates = null;
        while (isCorrectInput == false) {
            String input = scanner.nextLine();
            cellCoordinates = parseInput(input);
            isCorrectInput = CheckInput(cellCoordinates, field);
            if (isCorrectInput == false) {
                System.out.print(INCORRECT_CELL_INPUT_MESSAGE);
            } else {
                break;
            }
        }

        return field.getCell(cellCoordinates.getX(), cellCoordinates.getY());
    }

    private Coordinates parseInput(String input) {
        int x = input.charAt(0) - 'a';
        int y = input.charAt(1) - '1';
        Coordinates coordinates = new Coordinates(y, x);
        return coordinates;
    }

    @Override
    public Boolean CheckInput(Coordinates cell, Field field) {
        if (cell.getX() < 0 || cell.getX() > 7 || cell.getY() < 0 || cell.getY() > 7) {
            return false;
        }
        if (field.getCell(cell.getX(), cell.getY()).getValue() != CellValue.POSSIBLE_MOVE) {
            return false;
        }
        return true;
    }

    @Override
    public GameStage getMenuOption(MainMenu menu) {
        System.out.print(INPUT_MENU_MESSAGE);
        String input = scanner.nextLine();
        // check if input is a number
        while (!input.matches("\\d+") || Integer.parseInt(input) > menu.getMenuItems().size()
                || Integer.parseInt(input) < 1) {
            System.out.print(INCORRECT_MENU_INPUT_MESSAGE);
            input = scanner.nextLine();
        }
        int option = Integer.parseInt(input);
        return menu.getMenuItems().get(option - 1).getMenuItemValue();
    }
}
