package org.mix.xo.controllers;

import org.mix.xo.model.Field;
import org.mix.xo.model.Figure;
import org.mix.xo.model.exception.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), point -> new Point(point.x, point.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }
            }

            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0, i), point -> new Point(point.x + 1, point.y))) {
                    return field.getFigure(new Point(0, i));
                }
            }

            if (check(field, new Point(0, 0), point -> new Point(point.x + 1, point.y + 1))) {
                return field.getFigure(new Point(0, 0));
            }

            if (check(field, new Point(2, 0), point -> new Point(point.x - 1, point.y + 1))) {
                return field.getFigure(new Point(0, 2));
            }

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean check(final Field field, final Point startPoint, IPointChanger iPointChanger) {

        final Point p1 = startPoint;
        final Point p2 = iPointChanger.next(p1);
        final Point p3 = iPointChanger.next(p2);

        try {
            return (field.getFigure(p1) == field.getFigure(p2)) && (field.getFigure(p2) == field.getFigure(p3))
                    && (field.getFigure(p1) != null);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;
    }

    private interface IPointChanger {

        Point next(final Point point);

    }
}
