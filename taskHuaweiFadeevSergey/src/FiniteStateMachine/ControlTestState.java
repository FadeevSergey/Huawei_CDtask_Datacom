package FiniteStateMachine;

import java.io.IOException;

class ControlTestState extends AbstractTakeExamOrTestState implements HasTransitionToNextState {

    ControlTestState(String message) {
        super(message);
    }

    @Override
    void readMark() {
        System.out.println("--- Please input you mark of ControlTest. ---");
        super.readMark();
    }

    @Override
    public void transitionToNextState() throws IOException {
        PeriodOfLecturesState lecturesOfSecondSemester = new PeriodOfLecturesState("Lecture period.", 2);
        lecturesOfSecondSemester.printMessage();
        lecturesOfSecondSemester.transitionToNextState();
    }
}
