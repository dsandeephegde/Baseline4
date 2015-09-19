//View takes care of console input and output of the Application
package com.thoughtworks.baseline;

import java.io.PrintStream;
import java.util.Scanner;

public class View {
    private Scanner scanner;
    private PrintStream printStream;

    public View(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public String input() {
        return scanner.nextLine();
    }

    public void output(String message) {
        printStream.print(message);
    }
}
