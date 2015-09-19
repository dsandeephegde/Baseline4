package com.thoughtworks.baseline;

public class ConvertStateToString {

    private State[][] finalStates;

    public ConvertStateToString(State[][] finalStates) {

        this.finalStates = finalStates;
    }

    public String getString() {
        String finalState = "";
        for (int i = 0; i < finalStates.length; i++) {
            for (int j = 0; j < finalStates[i].length; j++) {
                if(finalStates[i][j] == State.ALIVE)
                    finalState += "X";
                else
                    finalState += "-";
            }
            finalState += "\n";
        }
        return finalState;
    }
}
