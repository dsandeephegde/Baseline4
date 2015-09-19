//Controls the flow of application
package com.thoughtworks.baseline;

import java.util.ArrayList;

public class Controller {

    private View view;
    private Universe universe;

    public Controller(View view) {
        this.view = view;
    }

    public void runApplication() {
        view.output("Enter Number of rows in Universe\n");
        int numberOfRows = getNumberOfRows();
        ArrayList<String> universeString = new ArrayList<String>();
        for (int i = 0; i < numberOfRows; i++) {
            universeString.add(view.input());
        }
        Parser parser = new Parser(universeString);
        State[][] states = parser.parse();
        Universe universe = new Universe(states);
        State[][] finalStates = universe.tick();

    }

    private int getNumberOfRows() {
        int numberOfRows = 0;
        try {
             numberOfRows = Integer.parseInt(view.input());
        } catch (Exception ignored) {
        }
        return numberOfRows;
    }
}
