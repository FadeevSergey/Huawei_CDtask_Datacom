package FiniteStateMachine;

abstract class State {

    final private String message;

    State(final String message) {
        this.message = message;
    }

    protected String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println("~~~ " + message + " ~~~");
    }

}
