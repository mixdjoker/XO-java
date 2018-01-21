package org.mix.xo.model;

import org.junit.Test;
import org.mix.xo.model.exception.*;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    private final Point inputPoint = new Point(2, 2);
    private final Figure inputFigureX = Figure.X;
    private final Field baseField = new Field();

    @Test
    public void getSize() {
        final int testValue = 3;
        final Field field = new Field();

        assertEquals(testValue, field.getSize());
    }

    @Test
    public void setFigure() throws XOException {
        final Figure expectedFigureX = inputFigureX;

        baseField.setFigure(inputPoint, inputFigureX);

        final Figure actualFigure = baseField.getFigure(inputPoint);

        assertEquals(expectedFigureX, actualFigure);
    }

    @Test
    public void setFigureWhenAlreadyOccupied() throws XOException {
        baseField.setFigure(inputPoint, inputFigureX);

        try {
            baseField.setFigure(inputPoint, inputFigureX);
            fail();
        } catch (AlreadyOccupiedException e) {
            System.out.println("AlreadyOccupied test passed");
        }



    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws XOException {
        final Figure actualFigure = baseField.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenPointIsLessZero() throws XOException {
        final Point pointXLess = new Point(-2, 2);
        final Point pointYLess = new Point(2, -2);
        final Point pointXYLess = new Point(-2, -2);

        try {
            baseField.getFigure(pointXLess);
            fail();
        } catch (InvalidPointException e) {
            System.out.println("Test for the pointXLess passed");
        }

        try {
            baseField.getFigure(pointYLess);
            fail();
        } catch (InvalidPointException e) {
            System.out.println("Test for the pointYLess passed");
        }

        try {
            baseField.getFigure(pointXYLess);
            fail();
        } catch (InvalidPointException e) {
            System.out.println("Test for the pointXYLess passed");
        }
    }

    @Test
    public void testGetFigureWhenPointIsMoreSize() throws XOException {
        final Point pointXMore = new Point(5, 2);
        final Point pointYMore = new Point(2, 5);
        final Point pointXYMore = new Point(5, 5);

        try {
            baseField.getFigure(pointXMore);
            fail();
        } catch (InvalidPointException e) {
            System.out.println("Test for the pointXMore passed");
        }

        try {
            baseField.getFigure(pointYMore);
            fail();
        } catch (InvalidPointException e) {
            System.out.println("Test for the pointYMore passed");
        }

        try {
            baseField.getFigure(pointXYMore);
            fail();
        } catch (InvalidPointException e) {
            System.out.println("Test for the pointXYMore passed");
        }
    }
}