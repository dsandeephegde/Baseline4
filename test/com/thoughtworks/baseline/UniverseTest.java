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

    @Test
    public void shouldReturnAllDead() {
        State[][] states = new State[2][2];
        states[0][0] = State.DEAD;
        states[1][0] = State.DEAD;
        states[0][1] = State.ALIVE;
        states[1][1] = State.DEAD;
        State[][] deadStates = new State[2][2];
        deadStates[0][0] = State.DEAD;
        deadStates[1][0] = State.DEAD;
        deadStates[0][1] = State.DEAD;
        deadStates[1][1] = State.DEAD;

        Universe universe = new Universe(states);

        assertEquals(deadStates, universe.tick());
    }

    @Test
    public void shouldReturnNumberOfAliveNeighbours() {
        State[][] states = new State[2][2];
        states[0][0] = State.DEAD;
        states[1][0] = State.ALIVE;
        states[0][1] = State.ALIVE;
        states[1][1] = State.DEAD;
        Universe universe = new Universe(states);

        assertEquals(2, universe.numberOfLiveNeighbours(1, 1));
    }

    @Test
    public void shouldNotConsiderTheCurrentNodeForAliveNeighbours() {
        State[][] states = new State[2][2];
        states[0][0] = State.DEAD;
        states[1][0] = State.ALIVE;
        states[0][1] = State.ALIVE;
        states[1][1] = State.DEAD;
        Universe universe = new Universe(states);

        assertEquals(1, universe.numberOfLiveNeighbours(1, 0));

    }
}