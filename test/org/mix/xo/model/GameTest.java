package org.mix.xo.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    private final String inputGameName = "Test game";
    private final Player[] inputPlayers = {
            new Player("Player 1", Figure.X),
            new Player("Player 2", Figure.O),
    };
    final Field inputField = new Field();


    @Test
    public void getName() {
        final Game game = new Game(inputGameName, inputPlayers, inputField);

        final String actualGameName = game.getName();

        assertEquals(inputGameName, actualGameName);
    }

    @Test
    public void getPlayers() {
        final Game game = new Game(inputGameName, inputPlayers, inputField);

        final Player[] actualPlayers = game.getPlayers();

        assertArrayEquals(inputPlayers, actualPlayers);
    }

    @Test
    public void getField() {
        final Game game = new Game(inputGameName, inputPlayers, inputField);

        final Field actalField = game.getField();

        assertEquals(inputField, actalField);
    }
}