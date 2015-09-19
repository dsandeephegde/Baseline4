//Contains the cells states in a universe
package com.thoughtworks.baseline;

public class Universe {

    private State[][] states;

    public Universe(State[][] states) {
        this.states = states;
    }

    public State[][] tick() {
        return new State[0][];
    }
}
