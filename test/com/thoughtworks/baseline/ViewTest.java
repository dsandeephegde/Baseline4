package com.thoughtworks.baseline;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ViewTest {

    @Test
    public void shouldTakeStringInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("XX".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        View view = new View(scanner, new PrintStream(System.out));
        assertEquals("XX", view.input());
        System.setIn(System.in);
    }

    @Test
    public void shouldDisplayTheGivenMessage() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        PrintStream printStream = new PrintStream(System.out);
        View view = new View(new Scanner(System.in), printStream);
        view.output("XX\nXX\n");
        assertEquals("XX\nXX\n", outContent.toString());
        System.setOut(System.out);
    }
}