package io.awklabs.sorting.heapsort;

import org.junit.jupiter.api.BeforeEach;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class HeapSortTest extends SortingAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getHeapSort();
  }
}
