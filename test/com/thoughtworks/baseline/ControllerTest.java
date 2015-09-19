package com.thoughtworks.baseline;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void shouldAskUserHowManyRowsInUniverse() {
        View view = mock(View.class);
        Controller controller = new Controller(view);
        when(view.input()).thenReturn("1");
        controller.runApplication();
        verify(view).output("Enter Number of rows in Universe\n");
    }

    @Test
    public void shouldTakeInTheNumberOfRows() {
        View view = mock(View.class);
        Controller controller = new Controller(view);
        when(view.input()).thenReturn("0");
        controller.runApplication();
        verify(view).input();
    }

    @Test
    public void shouldNotFailIfValueEnteredIsInvalid() {
        View view = mock(View.class);
        Controller controller = new Controller(view);
        when(view.input()).thenReturn("invalid");
        controller.runApplication();
        verify(view).input();
    }

    @Test
    public void shouldGetTheInputNumberOfRowsTimes() {
        View view = mock(View.class);
        Controller controller = new Controller(view);
        when(view.input()).thenReturn("4");
        controller.runApplication();
        verify(view, times(4 + 1)).input();
    }
}