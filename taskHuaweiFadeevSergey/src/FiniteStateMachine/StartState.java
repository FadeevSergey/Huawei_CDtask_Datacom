package FiniteStateMachine;

import java.io.IOException;

/**
 * @author Sergey Fadeev
 * 02.2020
 */

public class StartState extends State implements HasTransitionToNextState {

    public StartState(final String message) {
        super(message);
    }

    @Override
    public void transitionToNextState() throws IOException {
        final PeriodOfLecturesState lectures = new PeriodOfLecturesState("Lecture period", 1);
        lectures.printMessage();
        lectures.transitionToNextState();
    }
}
