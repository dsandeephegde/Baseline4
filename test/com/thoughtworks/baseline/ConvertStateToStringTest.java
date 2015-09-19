package com.thoughtworks.baseline;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertStateToStringTest {

    @Test
    public void shouldReturnTheCorrectString() {
        State[][] states = new State[2][2];
        states[0][0] = State.ALIVE;
        states[1][0] = State.ALIVE;
        states[0][1] = State.ALIVE;
        states[1][1] = State.ALIVE;
        ConvertStateToString convertStateToString = new ConvertStateToString(states);
        assertEquals("XX\nXX\n", convertStateToString.getString());
    }
}