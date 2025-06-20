package aw.algorithms.datastructures.stack;

/**
 * Non growing Fixed Size Stack implementation. Maximum elements supported is 256.
 *
 * @param <T>
 */
@SuppressWarnings({"unchecked"})
public class Stack<T> {

  private final T[] elements;

  private int maximumSize;

  private int elementCount;

  public Stack(int initialCapacity) {
    maximumSize = initialCapacity;
    if (initialCapacity > 256) {
      maximumSize = 256;
    }
    elements = (T[]) new Object[maximumSize];
    elementCount = 0;
  }

  public void push(T element) {
    if (elementCount >= maximumSize) {
      throw new RuntimeException("Stack Overflow. Maximum size reached");
    }
    elements[elementCount++] = element;
  }

  public T peek() {
    if (elementCount == 0) {
      throw new RuntimeException("Stack Empty");
    }
    return elements[elementCount - 1];
  }

  public T pop() {
    if (elementCount == 0) {
      throw new RuntimeException("Stack Empty");
    }
    return elements[--elementCount];
  }

  public int size() {
    return elementCount;
  }

  public int capacity() {
    return maximumSize;
  }
}
