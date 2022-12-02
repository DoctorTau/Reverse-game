package com.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.models.Field.CellValue;
import com.game.models.Field.Field;

public class FieldTest {
    /**
     * Test updateFieldAfterMove method of Field class.
     */
    @Test
    public void updateFieldAfterMoveTest_Move_2_2_Cell_3_3_is_black() {
        Field field = new Field(8);
        field.setValue(2, 3, CellValue.BLACK);
        field.updateFieldAfterMove(field.getCell(2, 3));
        assertEquals(CellValue.BLACK, field.getCell(3, 3).getValue());
    }

    /**
     * Test updateFieldAfterMove method of Field class.
     */
    @Test
    public void updateFieldAfterMoveTest() {
        Field field = new Field(8);
        field.setValue(2, 2, CellValue.BLACK);
        field.updateFieldAfterMove(field.getCell(2, 2));
        assertEquals(CellValue.BLACK, field.getCell(3, 3).getValue());
    }

}
