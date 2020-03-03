package FiniteStateMachine;

class ExamState extends AbstractTakeExamOrTestState implements HasTransitionToNextState {

    ExamState(String message) {
        super(message);
    }

    @Override
    void readMark() {
        System.out.println("--- Please enter an exam mark. ---");
        super.readMark();
    }

    @Override
    public void transitionToNextState() {
        if (getMark() >= 3) {
            SuccessfulFinishState successfulFinish = new SuccessfulFinishState("--- Congratulations, you have passed the course! ---");
            successfulFinish.printMessage();
        } else {
            RetakeExamState retakeExam = new RetakeExamState("Retake exam.");
            retakeExam.printMessage();
            retakeExam.readMark();
            retakeExam.transitionToNextState();
        }
    }
}

