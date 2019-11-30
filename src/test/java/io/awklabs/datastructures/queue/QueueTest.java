package io.awklabs.datastructures.queue;

import io.awklabs.datastructures.DataStructuresTestBase;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class QueueTest extends DataStructuresTestBase {

    private Queue<Integer> integerQueue;

    @Override
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
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Queue Empty");
        integerQueue.deQueue();
    }

    @Test
    public void testEnQueueWhenQueueFull() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Queue full, Maximum size reached");
        Stream.of(data).forEach(integerQueue::enQueue);
        integerQueue.enQueue(30);
    }

    @Test
    public void testEmptyQueueFront() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Queue Empty");
        integerQueue.front();
    }

    @Test
    public void testEmptyQueueRear() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Queue Empty");
        integerQueue.rear();
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