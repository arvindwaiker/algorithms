package io.awklabs.datastructures.tree;

import io.awklabs.datastructures.DataStructuresTestBase;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

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
}