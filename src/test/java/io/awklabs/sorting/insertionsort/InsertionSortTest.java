package io.awklabs.sorting.insertionsort;

import org.junit.jupiter.api.BeforeEach;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class InsertionSortTest extends SortingAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getInsertionSort();
  }
}
