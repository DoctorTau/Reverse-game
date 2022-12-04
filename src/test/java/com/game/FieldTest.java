package com.game;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import com.game.models.Field.Cell;
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
        assertEquals(CellValue.EMPTY, field.getCell(2, 2).getValue());
        assertEquals(CellValue.WHITE, field.getCell(4, 4).getValue());
    }

    /**
     * Test updateFieldAfterMove method of Field class.
     */
    @Test
    public void updateFieldAfterMoveTest() {
        Field field = new Field(8);
        field.setValue(3, 2, CellValue.BLACK);
        field.updateFieldAfterMove(field.getCell(3, 2));
        field.setValue(2, 4, CellValue.WHITE);
        field.updateFieldAfterMove(field.getCell(2, 4));
        assertEquals(CellValue.WHITE, field.getCell(3, 4).getValue());
    }

    /**
     * Test getCellsForNextMove method of Field class.
     */
    @Test
    public void getCellsForNextMoveTest() {
        Field field = new Field(8);
        Set<Cell> cellsForNextMove = field.getCellsForNextMove(CellValue.BLACK);
        assertEquals(4, cellsForNextMove.size());
    }
}
