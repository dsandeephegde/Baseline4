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
}