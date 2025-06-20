package io.awklabs.datastructures.tree.heap;

import java.util.Comparator;

public class MinHeap<T> extends Heap<T> {
  public MinHeap(int initialCapacity, Comparator<? super T> c) {
    super(initialCapacity, c);
  }

  @Override
  protected boolean compare(T o1, T o2) {
    return comparator.compare(o1, o2) > 0;
  }
}
