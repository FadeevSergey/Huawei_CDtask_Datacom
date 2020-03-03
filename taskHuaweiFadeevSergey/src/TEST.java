import java.io.IOException;
import FiniteStateMachine.*;

/**
 * @author Sergey Fadeev
 * 02.2020
 */

public class TEST {
    private static void startStateMachine() throws IOException {
        StartState state = new StartState("You started to study the course");
        state.printMessage();
        state.transitionToNextState();
    }

    public static void main(String[] args) throws IOException {
        startStateMachine();

    }
}
