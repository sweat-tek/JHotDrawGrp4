package org.jhotdraw.draw.figure;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;

public class GivenSomeState extends Stage<GivenSomeState> {

    @ProvidedScenarioState
    DefaultDrawingView defaultDrawingView;

    @ProvidedScenarioState
    Figure ellipse;

    public GivenSomeState a_default_drawing_view() {
        defaultDrawingView = new DefaultDrawingView();
        defaultDrawingView.setDrawing(new QuadTreeDrawing());
        return self();
    }

    public GivenSomeState an_ellipse() {
        ellipse = new EllipseFigure();
        defaultDrawingView.getDrawing().add(ellipse);
        return self();
    }

}
