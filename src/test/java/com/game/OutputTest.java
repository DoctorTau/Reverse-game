package com.game;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.game.models.GameStage;
import com.game.models.Field.Field;
import com.game.models.Menu.MainMenu;
import com.game.models.Output.ConsoleOutput;

public class OutputTest {
    /**
     * Test getFieldStringMethod of ConsoleOutput
     */
    @Test
    public void testGetFieldString() {
        Field field = new Field(8);
        ConsoleOutput output = new ConsoleOutput();
        String fieldString = output.getFieldString(field);
        String expectedString = "1| | | | | | | | |\n" + "2| | | | | | | | |\n" + "3| | | | | | | | |\n"
                + "4| | | |W|B| | | |\n" + "5| | | |B|W| | | |\n" + "6| | | | | | | | |\n"
                + "7| | | | | | | | |\n" + "8| | | | | | | | |\n" + " |a|b|c|d|e|f|g|h|\n";
        output.fieldOutput(field);
        assertTrue(fieldString.equals(expectedString));
    }

    /**
     * Test getMenuAsString method of ConsoleOutputter
     *
     */
    @Test
    public void testGetMenuAsString() {
        MainMenu menu = new MainMenu(GameStage.MAIN_MENU);
        ConsoleOutput output = new ConsoleOutput();
        String menuString = output.getMenuAsString(menu);
        String expectedString = "1. Game with human\n" + "2. Game with AI (easy)\n"
                + "3. Game with AI (hard)\n" + "4. Exit\n";
        assertTrue(menuString.equals(expectedString));
    }

}
