package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.Figure;
import org.junit.Assert;

import java.util.List;
import java.util.Set;

public class ThenTheFigureIsOnTopOfAllOthers extends Stage<ThenTheFigureIsOnTopOfAllOthers> {

    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private Figure selectedFigure;

    public ThenTheFigureIsOnTopOfAllOthers thenTheFigureIsOnTopOfAllOthers(){
        List<Figure> figureList = editor.getActiveView().getDrawing().findFigures(editor.getActiveView().getDrawing().getDrawingArea());

        for (Figure figure : figureList) {
            if (!figure.equals(figure)) continue;

            if (figureList.indexOf(figure) > figureList.indexOf(selectedFigure)) {
                Assert.fail("The select figure was not at the top.");
            }
        }
        return self();
    }
}
