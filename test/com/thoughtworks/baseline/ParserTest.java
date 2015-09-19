package com.thoughtworks.baseline;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void shouldReturn2DArrayOfState() {
        ArrayList<String> strings = new ArrayList<String>();
        Parser parser = new Parser(strings);

        assertEquals((new State[0][]).getClass(), parser.parse().getClass());
    }

    @Test
    public void shouldReturnCorrectStateArray() {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("XX");
        strings.add("-X");
        Parser parser = new Parser(strings);
        State[][] states = new State[2][2];
        states[0][0] = State.ALIVE;
        states[1][0] = State.DEAD;
        states[0][1] = State.ALIVE;
        states[1][1] = State.ALIVE;

        assertEquals(states, parser.parse());
    }
}