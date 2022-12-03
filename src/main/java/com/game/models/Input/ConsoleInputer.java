package com.game.models.Input;

import java.util.Scanner;

import com.game.models.Field.Coordinates;

public class ConsoleInputer implements IInputer {
    private static final String INPUT_MESSAGE = "Enter cell number: ";
    private static final String INCORRECT_CELL_INPUT_MESSAGE = "Entered cell number is incorrect. Try again: ";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Coordinates getCell() {
        System.out.print(INPUT_MESSAGE);
        Boolean isCorrectInput = false;
        Coordinates cell = null;
        while (isCorrectInput == false) {
            String input = scanner.nextLine();
            cell = parseInput(input);
            isCorrectInput = CheckInput(cell);
            if (isCorrectInput == false) {
                System.out.print(INCORRECT_CELL_INPUT_MESSAGE);
            } else {
                break;
            }
        }

        return cell;
    }

    private Coordinates parseInput(String input) {
        int x = input.charAt(0) - 'a';
        int y = input.charAt(1) - '1';
        Coordinates coordinates = new Coordinates(y, x);
        return coordinates;
    }

    @Override
    public Boolean CheckInput(Coordinates cell) {
        if (cell.getX() < 0 || cell.getX() > 7 || cell.getY() < 0 || cell.getY() > 7) {
            return false;
        }
        return true;
    }
}
