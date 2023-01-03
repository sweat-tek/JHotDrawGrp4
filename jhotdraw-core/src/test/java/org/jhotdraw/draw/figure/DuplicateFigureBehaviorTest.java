package org.jhotdraw.draw.figure;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class DuplicateFigureBehaviorTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenACopyAppear> {

    @Test
    public void duplicate_figures() {
        given().a_default_drawing_view()
                .and().an_ellipse();
        when().selecting_the_ellipse()
                .and().duplicating_it();
        then().a_copy_appear();
    }
}
