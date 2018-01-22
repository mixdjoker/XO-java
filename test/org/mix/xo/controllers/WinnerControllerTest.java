package org.mix.xo.controllers;

import org.junit.Test;
import org.mix.xo.model.Field;
import org.mix.xo.model.Figure;
import org.mix.xo.model.exception.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    private static final int POINT_ARRAY_COUNT = 3;

    private void winnerCheckBody(Figure inputFigure, Point[] points) throws InvalidPointException {
        final Field field = new Field();

        final WinnerController winnerController = new WinnerController();

        for (Point point : points) {
            field.setFigure(point, inputFigure);
        }

        final Figure actualFigure = winnerController.getWinner(field);

        assertEquals(inputFigure, actualFigure);
    }

    private void winnerColumnCheck(Figure inputFigure) throws InvalidPointException {

        for (int i = 0; i < POINT_ARRAY_COUNT; i++) {
            final Point[] pointSetXArray = {
                    new Point(i, 0),
                    new Point(i, 1),
                    new Point(i, 2)
            };

            winnerCheckBody(inputFigure, pointSetXArray);
        }
    }

    private void winnerRowCheck(Figure inputFigure) throws InvalidPointException {

        for (int i = 0; i < POINT_ARRAY_COUNT; i++) {
            final Point[] pointSetOArray = {
                    new Point(0, i),
                    new Point(1, i),
                    new Point(2, i)
            };

            winnerCheckBody(inputFigure, pointSetOArray);
        }
    }

    @Test
    public void getWinnerColumnXCheck() throws InvalidPointException {

        final Figure inputFigure = Figure.X;

        winnerColumnCheck(inputFigure);
    }

    @Test
    public void getWinnerRowXCheck() throws InvalidPointException {

        final Figure inputFigure = Figure.X;

        winnerRowCheck(inputFigure);
    }

    @Test
    public void getWinnerColumnOCheck() throws InvalidPointException {

        final Figure inputFigure = Figure.O;

        winnerColumnCheck(inputFigure);
    }

    @Test
    public void getWinnerRowOCheck() throws InvalidPointException {

        final Figure inputFigure = Figure.O;

        winnerRowCheck(inputFigure);
    }

    @Test
    public void getNoWinnerColumnCheck() throws InvalidPointException {

        final Figure inputFigureX = Figure.X;
        final Figure inputFigureY = Figure.O;

        for (int i = 0; i < 3; i++) {
            final Field field = new Field();
            final Point inputPoint1 = new Point(i, 0);
            final Point inputPoint2 = new Point(i, 1);
            final Point inputPoint3 = new Point(i, 2);

            final WinnerController winnerController = new WinnerController();

            field.setFigure(inputPoint1, inputFigureX);
            field.setFigure(inputPoint2, inputFigureY);
            field.setFigure(inputPoint3, inputFigureX);

            final Figure actualFigure = winnerController.getWinner(field);

            assertEquals(null, actualFigure);
        }
    }

    @Test
    public void getWinnerDiagCheck() throws InvalidPointException {

        final Figure inputFigureX = Figure.X;

        final Field field = new Field();
        final Point inputPoint1 = new Point(0, 0);
        final Point inputPoint2 = new Point(1, 1);
        final Point inputPoint3 = new Point(2, 2);

        final WinnerController winnerController = new WinnerController();

        field.setFigure(inputPoint1, inputFigureX);
        field.setFigure(inputPoint2, inputFigureX);
        field.setFigure(inputPoint3, inputFigureX);

        final Figure actualFigure = winnerController.getWinner(field);

        assertEquals(inputFigureX, actualFigure);
    }

    @Test
    public void getNoWinnerDiagCheck() throws InvalidPointException {

        final Figure inputFigureX = Figure.X;
        final Figure inputFigureO = Figure.O;

        final Field field = new Field();
        final Point inputPoint1 = new Point(0, 0);
        final Point inputPoint2 = new Point(1, 1);
        final Point inputPoint3 = new Point(2, 2);

        final WinnerController winnerController = new WinnerController();

        field.setFigure(inputPoint1, inputFigureX);
        field.setFigure(inputPoint2, inputFigureO);
        field.setFigure(inputPoint3, inputFigureX);

        final Figure actualFigure = winnerController.getWinner(field);

        assertNull(actualFigure);
    }

    @Test
    public void getWinnerInvertDiagCheck() throws InvalidPointException {

        final Figure inputFigureX = Figure.X;

        final Field field = new Field();
        final Point inputPoint1 = new Point(0, 2);
        final Point inputPoint2 = new Point(1, 1);
        final Point inputPoint3 = new Point(2, 0);

        final WinnerController winnerController = new WinnerController();

        field.setFigure(inputPoint1, inputFigureX);
        field.setFigure(inputPoint2, inputFigureX);
        field.setFigure(inputPoint3, inputFigureX);

        final Figure actualFigure = winnerController.getWinner(field);

        assertEquals(inputFigureX, actualFigure);
    }

    @Test
    public void getNoWinnerInvertDiagCheck() throws InvalidPointException {

        final Figure inputFigureX = Figure.X;
        final Figure inputFigureO = Figure.O;

        final Field field = new Field();
        final Point inputPoint1 = new Point(0, 2);
        final Point inputPoint2 = new Point(1, 1);
        final Point inputPoint3 = new Point(2, 0);

        final WinnerController winnerController = new WinnerController();

        field.setFigure(inputPoint1, inputFigureX);
        field.setFigure(inputPoint2, inputFigureO);
        field.setFigure(inputPoint3, inputFigureX);

        final Figure actualFigure = winnerController.getWinner(field);

        assertNull(actualFigure);
    }
}