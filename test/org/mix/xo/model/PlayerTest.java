package org.mix.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() throws Exception {
        final String testValue = "Daniil";
        final String expectedValue = testValue;

        final Player player = new Player(testValue, null);

        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getFigure() throws Exception {
        final Figure testValue = Figure.X;
        final Figure expectedValue = testValue;

        final Player player = new Player(null, testValue);

        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);
    }
}