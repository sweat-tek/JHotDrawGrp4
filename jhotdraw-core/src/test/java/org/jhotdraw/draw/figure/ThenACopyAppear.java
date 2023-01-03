package org.jhotdraw.draw.figure;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DefaultDrawingView;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenACopyAppear extends Stage<ThenACopyAppear> {

    @ExpectedScenarioState
    DefaultDrawingView defaultDrawingView;

    public ThenACopyAppear a_copy_appear() {
        assertThat(defaultDrawingView.getDrawing().getChildCount()).isEqualTo(2);
        return self();
    }
}
