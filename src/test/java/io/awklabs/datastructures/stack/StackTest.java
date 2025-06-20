package io.awklabs.datastructures.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.awklabs.datastructures.DataStructuresTestBase;

public class StackTest extends DataStructuresTestBase {

  private Stack<Integer> integerStack;

  @Override
  @BeforeEach
  public void before() {
    super.before();
    integerStack = new Stack<>(10);
  }

  @Test
  public void testPush() {
    Stream.of(data).forEach(integerStack::push);
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
    assertThrows(RuntimeException.class, integerStack::pop, "Stack Empty");
  }

  @Test
  public void testEmptyStackWhenPeek() {
    assertThrows(RuntimeException.class, integerStack::peek, "Stack Empty");
  }

  @Test
  public void testStackOverflow() {
    Stream.of(data).forEach(integerStack::push);
    assertThrows(
        RuntimeException.class,
        () -> integerStack.push(10),
        "Stack Overflow. Maximum size reached");
  }

  @Test
  public void testDefaultSize() {
    Stack<Integer> stack = new Stack<>(257);
    assertEquals(256, stack.capacity());
  }
}
