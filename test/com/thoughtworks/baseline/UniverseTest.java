package com.thoughtworks.baseline;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniverseTest {

    @Test
    public void shouldReturnStateArray() {
        State[][] states = new State[0][];
        Universe universe = new Universe(states);

        assertEquals((new State[0][]).getClass(), universe.tick().getClass());
    }
}