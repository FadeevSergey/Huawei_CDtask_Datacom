package FiniteStateMachine;

/**
 * @author Sergey Fadeev
 * 02.2020
 */

class RetakeControlTestState extends AbstractTakeExamOrTestState {

    final private String[] messages = {
            "Very bad! You are lucky, the dean’s office gave one more attempt!",
            "Okay, pass it again",
            "They say that they want to expel you from the university. Try very well this time."};

    RetakeControlTestState(final String message) {
        super(message);
    }

    @Override
    void readMark() {
        System.out.println("--- Please input new mark ---");
        System.out.flush();
        while (!(getMark() >= 3 && getMark() <= 5)) {
            if (readNewValidMark()) {
                if (getMark() < 3) {
                    System.out.println("--- " + messages[(int) (Math.random() * 10) % messages.length] + " ---");
                }
            } else {
                System.out.println("--- Input your mark again ---");
            }
        }
        System.out.println("--- Congratulations, you were able to retake the test! ---");
    }

    @Override
    public void transitionToNextState() {
        final ExamState exam = new ExamState("The final exam begins.");
        exam.printMessage();
        exam.readMark();
        exam.transitionToNextState();
    }
}