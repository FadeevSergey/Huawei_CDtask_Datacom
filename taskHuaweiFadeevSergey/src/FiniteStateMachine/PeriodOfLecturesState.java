package FiniteStateMachine;

import java.io.IOException;

public class PeriodOfLecturesState extends State implements HasTransitionToNextState {
    final private int moduleNumber;

    PeriodOfLecturesState(final String message, final int moduleNumber) {
        super(message);
        this.moduleNumber = moduleNumber;
    }

    @Override
    public void printMessage() {
        System.out.println("~~~ " + getMessage() + " module № " + moduleNumber + " ~~~");
    }

    @Override
    public void transitionToNextState() throws IOException {
        if (moduleNumber == 1) {
            ControlTestState controlTest = new ControlTestState("Intermodular control test");
            controlTest.printMessage();
            controlTest.readMark();
            controlTest.transitionToNextState();
        } else {
            PreExamWeekState preExam = new PreExamWeekState("The pre-examination week began.");
            preExam.printMessage();
            preExam.transitionToNextState();
        }
    }
}
