package FiniteStateMachine;

import java.io.IOException;

public interface HasTransitionToNextState {
    void transitionToNextState() throws IOException;
}
