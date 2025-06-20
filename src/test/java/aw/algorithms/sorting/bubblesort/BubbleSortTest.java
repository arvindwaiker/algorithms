package aw.algorithms.sorting.bubblesort;

import org.junit.jupiter.api.BeforeEach;

import aw.algorithms.sorting.SortingAlgorithmTestBase;

public class BubbleSortTest extends SortingAlgorithmTestBase {

  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getBubbleSort();
  }
}
