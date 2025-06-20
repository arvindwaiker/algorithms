package io.awklabs.datastructures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.awklabs.datastructures.DataStructuresTestBase;

public class QueueTest extends DataStructuresTestBase {

  private Queue<Integer> integerQueue;

  @Override
  @BeforeEach
  public void before() {
    super.before();
    integerQueue = new Queue<>(10);
  }

  @Test
  public void testEnQueue() {
    Stream.of(data).forEach(integerQueue::enQueue);
    assertEquals(10, integerQueue.size());
    assertEquals(Integer.valueOf(5), integerQueue.front());
    assertEquals(Integer.valueOf(9), integerQueue.rear());
  }

  @Test
  public void testDeQueue() {
    Stream.of(data).forEach(integerQueue::enQueue);
    assertEquals(Integer.valueOf(5), integerQueue.deQueue());
    assertEquals(9, integerQueue.size());
  }

  @Test
  public void testDeQueueAndEnQueue() {
    Stream.of(data).forEach(integerQueue::enQueue);
    assertEquals(Integer.valueOf(5), integerQueue.deQueue());
    assertEquals(9, integerQueue.size());
    integerQueue.enQueue(20);
    assertEquals(Integer.valueOf(20), integerQueue.rear());
  }

  @Test
  public void testEmptyQueueDeQueue() {
    assertThrows(RuntimeException.class, integerQueue::deQueue, "Queue Empty");
  }

  @Test
  public void testEnQueueWhenQueueFull() {
    Stream.of(data).forEach(integerQueue::enQueue);
    assertThrows(
        RuntimeException.class, () -> integerQueue.enQueue(30), "Queue full, Maximum size reached");
  }

  @Test
  public void testEmptyQueueFront() {
    assertThrows(RuntimeException.class, integerQueue::front, "Queue Empty");
  }

  @Test
  public void testEmptyQueueRear() {
    assertThrows(RuntimeException.class, integerQueue::rear, "Queue Empty");
  }

  @Test
  public void testDefaultSize() {
    Queue<Object> queue = new Queue<>();
    assertEquals(256, queue.capacity());
  }

  @Test
  public void testMaxSize() {
    Queue<Object> queue = new Queue<>(257);
    assertEquals(256, queue.capacity());
  }
}
