package io.awklabs.datastructures.queue;

/**
 * Non growing fixed size queue implementation. Maximum size supported is 256. This Queue is
 * implemented in a circular way.
 *
 * @param <T>
 */
@SuppressWarnings({"unchecked"})
public class Queue<T> {

  private final T[] elements;

  private int head;

  private int tail;

  private int maximumSize;

  private int elementCount;

  public Queue() {
    this(256);
  }

  public Queue(int initialCapacity) {
    maximumSize = initialCapacity;
    if (initialCapacity > 256) {
      maximumSize = 256;
    }
    this.elementCount = 0;
    this.head = 0;
    this.tail = -1;
    this.elements = (T[]) new Object[maximumSize];
  }

  public void enQueue(T element) {
    int nextIndex = (tail + 1) % maximumSize;
    if (elementCount == maximumSize) {
      throw new RuntimeException("Queue full, Maximum size reached");
    }
    elements[nextIndex] = element;
    elementCount++;
    tail = nextIndex;
  }

  public T deQueue() {
    if (elementCount == 0) {
      throw new RuntimeException("Queue Empty");
    }
    T element = elements[head];
    elements[head] = null;
    head = (head + 1) % maximumSize;
    elementCount--;
    return element;
  }

  public T front() {
    if (elementCount == 0) {
      throw new RuntimeException("Queue Empty");
    }
    return elements[head];
  }

  public T rear() {
    if (elementCount == 0) {
      throw new RuntimeException("Queue Empty");
    }
    return elements[tail];
  }

  public int size() {
    return elementCount;
  }

  public int capacity() {
    return maximumSize;
  }
}
