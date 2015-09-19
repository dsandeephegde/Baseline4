package com.thoughtworks.baseline;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    @Test
    public void shouldAskUserHowManyRowsInUniverse() {
        View view = mock(View.class);
        Controller controller = new Controller(view);
        controller.runApplication();
        verify(view).output("Enter Number of rows in Universe\n");
    }
}