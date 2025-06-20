package io.awklabs.sorting.mergesort;

import org.junit.jupiter.api.BeforeEach;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class MergeSortTest extends SortingAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getMergeSort();
  }
}
