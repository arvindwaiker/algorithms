package io.awklabs.datastructures.tree;

import io.awklabs.datastructures.DataStructuresTestBase;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HeapTest extends DataStructuresTestBase {

    Heap<Integer> minHeap = new Heap<>(10, true, Integer::compareTo);
    Heap<Integer> maxHeap = new Heap<>(10, false, Integer::compareTo);

    @Test
    public void testMinHeap() {
        Stream.of(data).forEach(minHeap::insertKey);
        Integer[] expected = {1, 2, 3, 4, 5, 8, 7, 10, 6, 9};
        assertArrayEquals(expected, minHeap.getElements());
    }

    @Test
    public void testMaxHeap() {
        Stream.of(data).forEach(maxHeap::insertKey);
        Integer[] expected = {10, 9, 7, 5, 8, 6, 3, 1, 4, 2};
        assertArrayEquals(expected, maxHeap.getElements());
    }

    @Test
    public void testMaximumSize() {
        Heap<Integer> heap = new Heap<>(257, true, Integer::compareTo);
        assertEquals(256, heap.capacity());
    }

    @Test
    public void testExtractMin() {
        Stream.of(data).forEach(minHeap::insertKey);
        assertEquals(Integer.valueOf(1), minHeap.extractMinimum());
        Integer[] result = {2, 4, 3, 6, 5, 8, 7, 10, 9};
        assertArrayEquals(result, minHeap.getElements());

    }

    @Test
    public void testHeapFull() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Heap Full");
        Stream.of(data).forEach(maxHeap::insertKey);
        maxHeap.insertKey(20);
    }
}