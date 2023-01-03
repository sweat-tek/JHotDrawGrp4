/*
 * @(#)Gradient.java
 *
 * Copyright (c) 1996-2010 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.samples.figures;

import org.jhotdraw.draw.figure.Figure;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Represents an SVG Gradient.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public interface Gradient extends Cloneable {

    public Paint getPaint(Figure f, double opacity);

    public boolean isRelativeToFigureBounds();

    public void transform(AffineTransform tx);

    public Object clone();

    public void makeRelativeToFigureBounds(Figure f);
}
