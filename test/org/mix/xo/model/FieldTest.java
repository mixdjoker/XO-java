package org.mix.xo.model;

import org.junit.Test;
import org.mix.xo.model.exception.AlreadyOccupiedException;
import org.mix.xo.model.exception.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    private final Point inputPoint = new Point(2, 2);
    private final Figure inputFigureX = Figure.X;

    @Test
    public void getSize() {
        final int testValue = 3;
        final Field field = new Field();

        assertEquals(testValue, field.getSize());
    }

    @Test
    public void setFigure() throws AlreadyOccupiedException, InvalidPointException {
        final Figure expectedFigureX = inputFigureX;
        final Field field = new Field();

        field.setFigure(inputPoint, inputFigureX);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(expectedFigureX, actualFigure);
    }
}