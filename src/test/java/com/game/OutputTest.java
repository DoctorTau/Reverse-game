package com.game;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.game.models.Field.Field;
import com.game.models.Output.ConsoleOutputter;

public class OutputTest {
    /**
     * Test getFieldStringMethod of ConsoleOutputter
     */
    @Test
    public void testGetFieldString() {
        Field field = new Field(8);
        ConsoleOutputter outputter = new ConsoleOutputter();
        String fieldString = outputter.getFieldString(field);
        String expectedString = "1| | | | | | | | |\n" + "2| | | | | | | | |\n" + "3| | | | | | | | |\n"
                + "4| | | |W|B| | | |\n" + "5| | | |B|W| | | |\n" + "6| | | | | | | | |\n"
                + "7| | | | | | | | |\n" + "8| | | | | | | | |\n" + " |a|b|c|d|e|f|g|h|\n";
        outputter.fieldOutput(field);
        assertTrue(fieldString.equals(expectedString));
    }

}