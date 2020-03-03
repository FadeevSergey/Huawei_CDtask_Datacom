package FiniteStateMachine;

/**
 * @author Sergey Fadeev
 * 02.2020
 */

class RetakeExamState extends AbstractTakeExamOrTestState {
    private int numberOfTry;

    RetakeExamState(final String message) {
        super(message);
    }

    @Override
    void readMark() {
        System.out.println("Please input new mark");
        while (numberOfTry <= 1 && !(getMark() >= 3 && getMark() <= 5)) {
            if (readNewValidMark()) {
                if (getMark() < 3) {
                    if (numberOfTry == 0) {
                        System.out.println("--- Okay, you can retake the exam again, but this will be the last time. ---");
                    }
                    numberOfTry++;
                }
            } else {
                System.out.println("--- Input valid mark ---");
            }
        }

        if (getMark() >= 3) {
            System.out.println("--- Congratulations, you were able to retake the exam. ---");
        } else {
            System.out.println("--- Unfortunately you did not pass the exam and failed the retake. ---");
        }
    }

    @Override
    public void transitionToNextState() {
        if (getMark() >= 3) {
            final SuccessfulFinishState retakeExam = new SuccessfulFinishState("Congratulations, you have passed the course!");
            retakeExam.printMessage();
        } else {
            final UniversityExpulsion universityExpulsion = new UniversityExpulsion("You are expelled from the university.");
            universityExpulsion.printMessage();
        }
    }
}
