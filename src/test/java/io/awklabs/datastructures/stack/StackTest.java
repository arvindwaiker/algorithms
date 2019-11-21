package io.awklabs.datastructures.stack;

import io.awklabs.datastructures.DataStructuresTestBase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StackTest extends DataStructuresTestBase {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    private Stack<Integer> integerStack;

    @Override
    public void before() {
        super.before();
        integerStack = new Stack<>(10);
    }

    @Test
    public void testPush() {
        for (Integer element: data) {
            integerStack.push(element);
        }
        assertEquals(10, integerStack.size());
        assertEquals(Integer.valueOf(9), integerStack.peek());
    }

    @Test
    public void testPop() {
        integerStack.push(10);
        integerStack.push(20);

        assertEquals(Integer.valueOf(20), integerStack.pop());
        assertEquals(1, integerStack.size());
    }

    @Test
    public void testPeek() {
        integerStack.push(10);
        integerStack.push(20);

        assertEquals(Integer.valueOf(20), integerStack.peek());
        assertEquals(2, integerStack.size());
    }

    @Test
    public void testEmptyStackWhenPop() {
        expected.expect(RuntimeException.class);
        expected.expectMessage("Stack Empty");
        integerStack.pop();
    }

    @Test
    public void testEmptyStackWhenPeek() {
        expected.expect(RuntimeException.class);
        expected.expectMessage("Stack Empty");
        integerStack.peek();
    }

    @Test
    public void testStackOverflow() {
        for (Integer element: data) {
            integerStack.push(element);
        }
        expected.expect(RuntimeException.class);
        expected.expectMessage("Stack Overflow. Maximum size reached");
        integerStack.push(10);
    }

    @Test
    public void testDefaultSize() {
        Stack<Integer> stack = new Stack<>(257);
        assertEquals(256, stack.capacity());
    }

}