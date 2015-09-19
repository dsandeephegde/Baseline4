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
    public void shouldReturnDeadForMoreThan3Neighbours() {
        State[][] states = new State[3][3];
        states[0][0] = State.ALIVE;
        states[1][0] = State.ALIVE;
        states[2][0] = State.DEAD;
        states[0][1] = State.DEAD;
        states[1][1] = State.ALIVE;
        states[2][1] = State.DEAD;
        states[0][2] = State.ALIVE;
        states[1][2] = State.ALIVE;
        states[2][2] = State.DEAD;

        State[][] finalStates = new State[3][3];
        finalStates[0][0] = State.ALIVE;
        finalStates[1][0] = State.ALIVE;
        finalStates[2][0] = State.DEAD;
        finalStates[0][1] = State.DEAD;
        finalStates[1][1] = State.DEAD;
        finalStates[2][1] = State.DEAD;
        finalStates[0][2] = State.ALIVE;
        finalStates[1][2] = State.ALIVE;
        finalStates[2][2] = State.DEAD;

        Universe universe = new Universe(states);

        assertEquals(finalStates, universe.tick());
    }

    @Test
    public void shouldReturnAliveIf2Or3LiveNeighbours() {
        State[][] states = new State[2][2];
        states[0][0] = State.ALIVE;
        states[1][0] = State.ALIVE;
        states[0][1] = State.ALIVE;
        states[1][1] = State.ALIVE;
        State[][] deadStates = new State[2][2];
        deadStates[0][0] = State.ALIVE;
        deadStates[1][0] = State.ALIVE;
        deadStates[0][1] = State.ALIVE;
        deadStates[1][1] = State.ALIVE;

        Universe universe = new Universe(states);

        assertEquals(deadStates, universe.tick());
    }

    @Test
    public void shouldReturnAliveExactly3LiveNeighbours() {
        State[][] states = new State[2][2];
        states[0][0] = State.ALIVE;
        states[1][0] = State.ALIVE;
        states[0][1] = State.ALIVE;
        states[1][1] = State.DEAD;
        State[][] deadStates = new State[2][2];
        deadStates[0][0] = State.ALIVE;
        deadStates[1][0] = State.ALIVE;
        deadStates[0][1] = State.ALIVE;
        deadStates[1][1] = State.ALIVE;

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