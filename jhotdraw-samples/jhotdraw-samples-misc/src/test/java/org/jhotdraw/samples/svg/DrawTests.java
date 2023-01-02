package org.jhotdraw.samples.svg;

import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.awt.*;
import java.awt.geom.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

public class DrawTests {

    @Test
    public void testDraw() {
        SVGEllipseFigure ellipseFigure = spy(SVGEllipseFigure.class);
        Graphics2D g = mock(Graphics2D.class);
        Rectangle2D.Double drawingArea = mock(Rectangle2D.Double.class);
        Rectangle clipBounds = mock(Rectangle.class);

        when(ellipseFigure.get(OPACITY)).thenReturn(0.5d);
        when(ellipseFigure.getDrawingArea()).thenReturn(drawingArea);
        when(g.getClipBounds()).thenReturn(clipBounds);
        when(drawingArea.isEmpty()).thenReturn(false);
        try {
            ellipseFigure.draw(g);
        } catch (NullPointerException ignored) {

        }

        verify(ellipseFigure).drawFigureOnExistingDrawing(g, 0.5f, drawingArea);
    }

    @Test
    public void testDrawOpacity1() {
        SVGEllipseFigure ellipseFigure = spy(SVGEllipseFigure.class);
        Graphics2D g = mock(Graphics2D.class);
        Rectangle2D.Double drawingArea = mock(Rectangle2D.Double.class);
        Rectangle clipBounds = mock(Rectangle.class);

        when(ellipseFigure.get(OPACITY)).thenReturn(1d);
        when(ellipseFigure.getDrawingArea()).thenReturn(drawingArea);
        when(g.getClipBounds()).thenReturn(clipBounds);
        when(drawingArea.isEmpty()).thenReturn(false);

        ellipseFigure.draw(g);

        verify(ellipseFigure).drawFigure(g);
    }
}
