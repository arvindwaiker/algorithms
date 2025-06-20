package io.awklabs.sorting.quicksort;

import org.junit.jupiter.api.BeforeEach;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class QuickSortTest extends SortingAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getQuickSort();
  }
}
