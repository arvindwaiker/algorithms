package io.awklabs.datastructures.tree.heap;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import io.awklabs.datastructures.DataStructuresTestBase;

public class HeapTest extends DataStructuresTestBase {

  Heap<Integer> minHeap = new MinHeap<>(10, Integer::compareTo);
  Heap<Integer> maxHeap = new MaxHeap<>(10, Integer::compareTo);

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
    Heap<Integer> heap = new MaxHeap<>(257, Integer::compareTo);
    assertEquals(256, heap.capacity());
  }

  @Test
  public void testExtractMin() {
    Stream.of(data).forEach(minHeap::insertKey);
    assertEquals(Integer.valueOf(1), minHeap.deleteRoot());
    Integer[] result = {2, 4, 3, 6, 5, 8, 7, 10, 9};
    assertArrayEquals(result, minHeap.getElements());
  }

  @Test
  public void testExtractMax() {
    Stream.of(data).forEach(maxHeap::insertKey);
    assertEquals(Integer.valueOf(10), maxHeap.deleteRoot());
    Integer[] result = {9, 8, 7, 5, 2, 6, 3, 1, 4};
    assertArrayEquals(result, maxHeap.getElements());
  }

  @Test
  public void testHeapFull() {
    Stream.of(data).forEach(maxHeap::insertKey);
    assertThrows(RuntimeException.class, () -> maxHeap.insertKey(20), "Heap Full");
  }
}
