package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.Figure;


public class WhenIPressBringToFront extends Stage<WhenIPressBringToFront> {
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    @ProvidedScenarioState
    private Figure selectedFigure;


    public WhenIPressBringToFront whenIPressBringToFront(){
        editor.getActiveView().getDrawing().bringToFront(selectedFigure);
        return self();
    }
}
