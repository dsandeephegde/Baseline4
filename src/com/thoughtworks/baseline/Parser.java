//parses the raw input and converts it to domain understandable object
package com.thoughtworks.baseline;

import java.util.ArrayList;

public class Parser {

    private ArrayList<String> universeString;

    public Parser(ArrayList<String> universeString) {
        this.universeString = universeString;
    }

    public State[][] parse() {
        return new State[0][];
    }
}
