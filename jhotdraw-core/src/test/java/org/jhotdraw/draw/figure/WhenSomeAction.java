package org.jhotdraw.draw.figure;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DefaultDrawingView;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenSomeAction extends Stage<WhenSomeAction> {
    @ExpectedScenarioState
    DefaultDrawingView defaultDrawingView;

    @ExpectedScenarioState
    Figure ellipse;

    public WhenSomeAction selecting_the_ellipse() {
        defaultDrawingView.addToSelection(ellipse);
        return self();
    }

    public WhenSomeAction duplicating_it() {
        assertThat(defaultDrawingView.getSelectedFigures()).isNotNull();
        defaultDrawingView.duplicate();
        return self();
    }
}
