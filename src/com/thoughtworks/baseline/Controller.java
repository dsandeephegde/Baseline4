package com.thoughtworks.baseline;

public class Controller {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void runApplication() {
        view.output("Enter Number of rows in Universe\n");
        int numberOfRows = getNumberOfRows();
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
