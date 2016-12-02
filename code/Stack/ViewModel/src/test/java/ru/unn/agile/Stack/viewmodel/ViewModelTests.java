package ru.unn.agile.Stack.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewModelTests {
    private ViewModel viewModel;
    private final Integer number = 12345;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canSetDefaultValues() {
        assertEquals("", viewModel.txtinputProperty().get());
        assertEquals("", viewModel.txtprintProperty().get());
        assertEquals("", viewModel.txtlogProperty().get());
        assertEquals("", viewModel.txtmsgProperty().get());
    }

    @Test
    public void badTyping() {
        viewModel.txtinputProperty().set("a");
        viewModel.push();
        assertEquals("Bad input!", viewModel.txtlogProperty().get());
    }

    @Test
    public void canPush() {
        viewModel.txtinputProperty().set("1");
        viewModel.push();
        assertEquals(1, (int) viewModel.getStack().top());
    }

    @Test
    public void canPushTwice() {
        viewModel.txtinputProperty().set("1");
        viewModel.push();
        viewModel.push();
        assertEquals(1, (int) viewModel.getStack().top());
        viewModel.pop();
        assertEquals(1, (int) viewModel.getStack().top());
    }

    @Test
    public void canPop() {
        viewModel.txtinputProperty().set("1");
        viewModel.push();
        assertEquals(1, (int) viewModel.getStack().pop());
    }

    @Test
    public void canPopFromEmptyStack() {
        assertNull(viewModel.getStack().pop());
        assertTrue(viewModel.isEmpty());
    }

    @Test
    public void canTop() {
        viewModel.txtinputProperty().set("1");
        viewModel.push();
        assertEquals(1, (int) viewModel.getStack().top());
    }

    @Test
    public void canTopFromEmptyStack() {
        assertNull(viewModel.getStack().top());
        assertTrue(viewModel.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(viewModel.isEmpty());
    }

    @Test
    public void testIsEmptyAfterPushThenPop() {
        viewModel.txtinputProperty().set("1");
        viewModel.push();
        viewModel.pop();
        assertTrue(viewModel.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        viewModel.txtinputProperty().set("1");
        viewModel.push();
        assertFalse(viewModel.isEmpty());
    }

    @Test
    public void testPrint() {
        viewModel.print();
        assertTrue(viewModel.getStack().isEmpty());
        viewModel.getStack().push(number);
        assertEquals(number, viewModel.getStack().top());
    }
}
