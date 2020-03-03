package FiniteStateMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Sergey Fadeev
 * 02.2020
 */

abstract class AbstractTakeExamOrTestState extends State implements HasTransitionToNextState {

    private static int mark;

    AbstractTakeExamOrTestState(final String message) {
        super(message);
    }

    static int getMark() {
        return mark;
    }

    void readMark() {
        boolean canRead = true;
        while (canRead) {
            canRead = !readNewValidMark();
        }
    }

    private void checkValidOfMark(final int mark) throws IllegalMarkException {
        if (mark < 0 || mark > 5) {
            throw new IllegalMarkException("The rating must belong to [0; 5]");
        }
    }

    boolean readNewValidMark() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String newString = reader.readLine();
            mark = Integer.valueOf(newString.split(" ")[0]);
            checkValidOfMark(mark);
            return true;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("+++ Invalid input value! +++");
        } catch (IllegalMarkException e) {
            System.err.println("+++ " + e.getMessage() + " +++");
        } catch (IOException e) {
            System.err.println("+++ IOException in AbstractRetakeState.readNewMark +++");
        }
        return false;
    }
}
