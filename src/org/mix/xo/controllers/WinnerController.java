package org.mix.xo.controllers;

import org.mix.xo.model.Field;
import org.mix.xo.model.Figure;
import org.mix.xo.model.exception.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i,0), new Point(i, 1), new Point(i, 2))) {
                    return field.getFigure(new Point(i, 0));
                }
            }

            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0,i), new Point(1, i), new Point(2, i))) {
                    return field.getFigure(new Point(0, i));
                }
            }

            if (check(field, new Point(0,0), new Point(1, 1), new Point(2, 2))) {
                return field.getFigure(new Point(0, 0));
            }

            if (check(field, new Point(2,0), new Point(1, 1), new Point(0, 2))) {
                return field.getFigure(new Point(0, 2));
            }

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean check(final Field field, final Point p1, final Point p2, final Point p3) {
        try {
            return (field.getFigure(p1) == field.getFigure(p2)) && (field.getFigure(p2) == field.getFigure(p3))
                    && (field.getFigure(p1) != null);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;
    }
}
