package org.jhotdraw.draw.action;

import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.RectangleFigure;
import org.junit.Assert;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.List;


public class ArrangeActionTest {

    /**
     * Add figures to the view.
     * @param view
     */
    void createSetup(DefaultDrawingView view){
        view.setDrawing(new DefaultDrawing());
        view.getDrawing().add(new RectangleFigure(10, 10, 100, 100));
        view.getDrawing().add(new RectangleFigure(10, 10, 100, 150));
    }

    /**
     * Test that the setup function works as intended.
     */
    @Test
    public void testCreateSetupNotEmpty(){
        DefaultDrawingView view = new DefaultDrawingView();
        createSetup(view);
        Assert.assertNotNull(view.getDrawing());
        List<Figure> figures = view.getDrawing().findFigures(view.getDrawing().getDrawingArea());
        Assert.assertFalse("Figures should not be empty since we added two.",
                figures.isEmpty());
    }

    /**
     * Test that if you send a figure to the back that it actually is send to the back.
     */
    @Test
    public void testSendToBack(){
        DefaultDrawingView view = new DefaultDrawingView();
        createSetup(view);

        Point2D.Double point =  view.getDrawing().getStartPoint();
        Figure topFigure = view.getDrawing().findFigure(point);
        Figure bottomFigure = view.getDrawing().findFigureBehind(point, topFigure);

        Assert.assertTrue("topFigure index should be greater than bottomFigure index.",
                view.getDrawing().indexOf(topFigure) > view.getDrawing().indexOf(bottomFigure)
                );

        view.getDrawing().sendToBack(topFigure); // Send figure to back

        Assert.assertTrue("bottomFigure index should be greater than topFigure index.",
                view.getDrawing().indexOf(bottomFigure) > view.getDrawing().indexOf(topFigure)
        );
    }

    @Test
    public void testBringToFront(){
        DefaultDrawingView view = new DefaultDrawingView();
        createSetup(view);

        Point2D.Double point =  view.getDrawing().getStartPoint();
        Figure topFigure = view.getDrawing().findFigure(point);
        Figure bottomFigure = view.getDrawing().findFigureBehind(point, topFigure);

        Assert.assertTrue("bottomFigure index should be greater than topFigure index.",
                view.getDrawing().indexOf(bottomFigure) < view.getDrawing().indexOf(topFigure)
        );

        view.getDrawing().bringToFront(bottomFigure); // Bring figure to the front

        Assert.assertTrue("bottomFigure index should be greater than topFigure index since it was moved to the front.",
                view.getDrawing().indexOf(topFigure) < view.getDrawing().indexOf(bottomFigure)
        );
    }
}