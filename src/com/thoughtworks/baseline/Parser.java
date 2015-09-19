//parses the raw input and converts it to domain understandable object
package com.thoughtworks.baseline;

import java.util.ArrayList;

public class Parser {

    private ArrayList<String> universeString;

    public Parser(ArrayList<String> universeString) {
        this.universeString = universeString;
    }

    public State[][] parse() {
        int size = universeString.size();
        State[][] states = new State[size][size];
        for (int i = 0; i < universeString.size(); i++) {
            for (int j = 0; j < universeString.get(i).length(); j++) {
                if(universeString.get(i).charAt(j) == 'X')
                    states[i][j] = State.ALIVE;
                else
                    states[i][j] = State.DEAD;
            }
        }
        return states;
    }
}