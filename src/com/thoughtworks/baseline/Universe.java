//Contains the cells states in a universe
package com.thoughtworks.baseline;

public class Universe {

    private State[][] states;

    public Universe(State[][] states) {
        this.states = states;
    }

    public State[][] tick() {
        State[][] finalStates = new State[states.length][states.length];
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < states[i].length; j++) {
                if(states[i][j] == State.ALIVE) {
                    if (numberOfLiveNeighbours(i, j) < 2) {
                        finalStates[i][j] = State.DEAD;
                    }
                    else if(numberOfLiveNeighbours(i, j) > 3) {
                        finalStates[i][j] = State.DEAD;
                    }
                    else {
                        finalStates[i][j] = State.ALIVE;
                    }
                }
                else {
                    finalStates[i][j] = State.DEAD;
                }
            }
        }
        return finalStates;
    }

    int numberOfLiveNeighbours(int rowNumber, int columnNumber) {
        int count = 0;
        for (int i = rowNumber - 1; i <= rowNumber + 1; i++) {
            for (int j = columnNumber - 1; j <= columnNumber + 1; j++) {
                if(!(i == rowNumber && j == columnNumber))
                try {
                    if (states[i][j] == State.ALIVE)
                        count++;
                } catch (Exception ignored) {
                }
            }
        }
        return count;
    }
}
