package org.jhotdraw.draw.action;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class FigureIsAtTheFrontBehaviorTest extends ScenarioTest<GivenOneDrawing, WhenIPressBringToFront, ThenTheFigureIsOnTopOfAllOthers> {
    @Test
    public void BringToFrontFigureBehaviour(){
        given().oneDrawing()
                .and().oneFigureOrMore()
                .and().selectFigure();
        when().whenIPressBringToFront();
        then().thenTheFigureIsOnTopOfAllOthers();
    }
}
