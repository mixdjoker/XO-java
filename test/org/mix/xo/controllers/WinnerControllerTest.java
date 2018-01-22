package org.mix.xo.controllers;

import org.junit.Test;
import org.mix.xo.model.Field;
import org.mix.xo.model.Figure;
import org.mix.xo.model.exception.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinnerColumnXCheck() throws InvalidPointException {

        final Figure inputFigure = Figure.X;

        for (int i = 0; i < 3; i++) {
            final Field field = new Field();
            final Point inputPoint1 = new Point(i, 0);
            final Point inputPoint2 = new Point(i, 1);
            final Point inputPoint3 = new Point(i, 2);

            final WinnerController winnerController = new WinnerController();

            field.setFigure(inputPoint1, inputFigure);
            field.setFigure(inputPoint2, inputFigure);
            field.setFigure(inputPoint3, inputFigure);

            final Figure actualFigure = winnerController.getWinner(field);

            assertEquals(inputFigure, actualFigure);
        }
    }

    @Test
    public void getWinnerRowXCheck() throws InvalidPointException {

        final Figure inputFigure = Figure.X;

        for (int i = 0; i < 3; i++) {
            final Field field = new Field();
            final Point inputPoint1 = new Point(0, i);
            final Point inputPoint2 = new Point(1, i);
            final Point inputPoint3 = new Point(2, i);

            final WinnerController winnerController = new WinnerController();

            field.setFigure(inputPoint1, inputFigure);
            field.setFigure(inputPoint2, inputFigure);
            field.setFigure(inputPoint3, inputFigure);

            final Figure actualFigure = winnerController.getWinner(field);

            assertEquals(inputFigure, actualFigure);
        }
    }

    @Test
    public void getWinnerColumnOCheck() throws InvalidPointException {

        final Figure inputFigure = Figure.O;

        for (int i = 0; i < 3; i++) {
            final Field field = new Field();
            final Point inputPoint1 = new Point(i, 0);
            final Point inputPoint2 = new Point(i, 1);
            final Point inputPoint3 = new Point(i, 2);

            final WinnerController winnerController = new WinnerController();

            field.setFigure(inputPoint1, inputFigure);
            field.setFigure(inputPoint2, inputFigure);
            field.setFigure(inputPoint3, inputFigure);

            final Figure actualFigure = winnerController.getWinner(field);

            assertEquals(inputFigure, actualFigure);
        }
    }

    @Test
    public void getWinnerRowOCheck() throws InvalidPointException {

        final Figure inputFigure = Figure.O;

        for (int i = 0; i < 3; i++) {
            final Field field = new Field();
            final Point inputPoint1 = new Point(0, i);
            final Point inputPoint2 = new Point(1, i);
            final Point inputPoint3 = new Point(2, i);

            final WinnerController winnerController = new WinnerController();

            field.setFigure(inputPoint1, inputFigure);
            field.setFigure(inputPoint2, inputFigure);
            field.setFigure(inputPoint3, inputFigure);

            final Figure actualFigure = winnerController.getWinner(field);

            assertEquals(inputFigure, actualFigure);
        }
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
}