package com.thoughtworks.baseline;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(view.input()).thenReturn("1");
        controller.runApplication();
        verify(view).input();
    }
}