package io.awklabs.sorting.bubblesort;

import org.junit.jupiter.api.BeforeEach;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class BubbleSortTest extends SortingAlgorithmTestBase {

  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getBubbleSort();
  }
}
