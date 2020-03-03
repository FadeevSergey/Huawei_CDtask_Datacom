package FiniteStateMachine;

/**
 * @author Sergey Fadeev
 * 02.2020
 */

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
