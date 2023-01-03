package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.EllipseFigure;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.RectangleFigure;

import java.util.List;

public class GivenOneDrawing extends Stage<GivenOneDrawing> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Figure selectedFigure;

    public GivenOneDrawing oneFigureOrMore(){
        Figure figure = new RectangleFigure(0,0,100,100);
        Figure figureTwo = new EllipseFigure(0,0,100,150);

        editor.getActiveView().getDrawing().add(figure);
        editor.getActiveView().getDrawing().add(figureTwo);
        return this;
    }

    public GivenOneDrawing selectFigure(){
        List<Figure> figureList = editor.getActiveView().getDrawing().findFigures(editor.getActiveView().getDrawing().getDrawingArea());

        Figure bottomFigure = figureList.get(0);

        editor.getActiveView().addToSelection(bottomFigure);
        selectedFigure = bottomFigure;
        return this;
    }

    public GivenOneDrawing oneDrawing(){
        editor = new DefaultDrawingEditor();
        editor.setActiveView(new DefaultDrawingView());
        editor.getActiveView().setDrawing(new DefaultDrawing());
        return this;
    }


}
