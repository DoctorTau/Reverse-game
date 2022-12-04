package com.game;

import org.junit.Test;

import com.game.models.Field.Coordinates;
import com.game.models.Input.ConsoleInput;
import com.game.models.Input.IGameInput;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputTest {
    private static final InputStream sysInBackup = System.in;

    @Test
    public void testInput_Get_a1_Expected_0_0() {
        String input = "a1";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IGameInput inputer = new ConsoleInput();
        Coordinates cords = inputer.getCell();
        assertEquals(0, cords.getX());
        assertEquals(0, cords.getY());
        System.setIn(sysInBackup);
    }

    @Test
    public void testInput_Get_a8_Expected_7_0() {
        String input = "a8";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IGameInput inputer = new ConsoleInput();
        Coordinates cords = inputer.getCell();
        assertEquals(7, cords.getX());
        assertEquals(0, cords.getY());
        System.setIn(sysInBackup);
    }

    @Test
    public void testInput_Get_h1_Expected_0_7() {
        String input = "h1";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IGameInput inputer = new ConsoleInput();
        Coordinates cords = inputer.getCell();
        assertEquals(0, cords.getX());
        assertEquals(7, cords.getY());
        System.setIn(sysInBackup);
    }

    @Test
    public void testInput_Get_h8_Expected_7_7() {
        String input = "h8";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IGameInput inputer = new ConsoleInput();
        Coordinates cords = inputer.getCell();
        assertEquals(7, cords.getX());
        assertEquals(7, cords.getY());
        System.setIn(sysInBackup);
    }

    @Test
    public void testInput_Get_a5_Expected_4_0() {
        String input = "a5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IGameInput inputer = new ConsoleInput();
        Coordinates cords = inputer.getCell();
        assertEquals(4, cords.getX());
        assertEquals(0, cords.getY());
        System.setIn(sysInBackup);
    }

    @Test
    public void testInput_Get_e1_Expected_0_4() {
        String input = "e1";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IGameInput inputer = new ConsoleInput();
        Coordinates cords = inputer.getCell();
        assertEquals(0, cords.getX());
        assertEquals(4, cords.getY());
        System.setIn(sysInBackup);
    }

    @Test
    public void testInput_Get_e5_Expected_4_4() {
        String input = "e5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IGameInput inputer = new ConsoleInput();
        Coordinates cords = inputer.getCell();
        assertEquals(4, cords.getX());
        assertEquals(4, cords.getY());
        System.setIn(sysInBackup);
    }

    @Test
    public void testInput_Get_e8_Expected_7_4() {
        String input = "e8";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IGameInput inputer = new ConsoleInput();
        Coordinates cords = inputer.getCell();
        assertEquals(7, cords.getX());
        assertEquals(4, cords.getY());
        System.setIn(sysInBackup);
    }

    @Test
    public void testInput_Get_h5_Expected_4_7() {
        String input = "h5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        IGameInput inputer = new ConsoleInput();
        Coordinates cords = inputer.getCell();
        assertEquals(4, cords.getX());
        assertEquals(7, cords.getY());
        System.setIn(sysInBackup);
    }
}
