package org.mix.xo.controllers;

import org.junit.Test;
import org.mix.xo.model.Field;
import org.mix.xo.model.Figure;
import org.mix.xo.model.exception.AlreadyOccupiedException;
import org.mix.xo.model.exception.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

public class MoveContrillerTest {
    final Point inputPoint = new Point(2, 2);
    final Figure inputFigure = Figure.X;
    final Field inputField = new Field();
    final MoveContriller moveContriller = new MoveContriller();

    @Test
    public void applyFigure() throws AlreadyOccupiedException, InvalidPointException {

        moveContriller.applyFigure(inputField, inputPoint, inputFigure);

        final Figure actualFigure = inputField.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void applyAlreadyOccupiedFigure() throws AlreadyOccupiedException, InvalidPointException {
        moveContriller.applyFigure(inputField, inputPoint, inputFigure);
        try {
            moveContriller.applyFigure(inputField, inputPoint, inputFigure);
            fail();
        } catch (AlreadyOccupiedException e) {
            System.out.println("AlreadyOccupiedFigure caught");
        }

    }
}