package io.awklabs.sorting.selectionsort;

import org.junit.jupiter.api.BeforeEach;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class SelectionSortTest extends SortingAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getSelectionSort();
  }
}
