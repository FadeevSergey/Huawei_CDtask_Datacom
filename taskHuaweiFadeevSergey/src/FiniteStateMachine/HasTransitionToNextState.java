package FiniteStateMachine;

import java.io.IOException;

/**
 * @author Sergey Fadeev
 * 02.2020
 */

public interface HasTransitionToNextState {
    void transitionToNextState() throws IOException;
}
