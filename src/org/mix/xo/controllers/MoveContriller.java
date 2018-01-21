package org.mix.xo.controllers;

import org.mix.xo.model.Field;
import org.mix.xo.model.Figure;
import org.mix.xo.model.exception.*;

import java.awt.*;

public class MoveContriller {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure)
                            throws AlreadyOccupiedException, InvalidPointException {

        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
