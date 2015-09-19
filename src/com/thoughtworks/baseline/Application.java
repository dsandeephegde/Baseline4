//Main Application which has main method
package com.thoughtworks.baseline;

import java.io.PrintStream;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(System.out);
        View view = new View(scanner, printStream);
        Controller controller = new Controller(view);
        controller.runApplication();
    }
}
