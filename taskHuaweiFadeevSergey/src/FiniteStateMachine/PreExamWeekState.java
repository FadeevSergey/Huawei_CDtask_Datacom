package FiniteStateMachine;

/**
 * @author Sergey Fadeev
 * 02.2020
 */

class PreExamWeekState extends State implements HasTransitionToNextState {
    PreExamWeekState(final String message) {
        super(message);
    }

    @Override
    public void transitionToNextState() {
        if (ControlTestState.getMark() < 3) {
            final RetakeControlTestState retakeTest = new RetakeControlTestState("You have a poor grade for the test. Retake it.");
            retakeTest.printMessage();
            retakeTest.readMark();
            retakeTest.transitionToNextState();
        } else {
            final ExamState exam = new ExamState("The final exam begins.");
            exam.printMessage();
            exam.readMark();
            exam.transitionToNextState();
        }
    }
}
