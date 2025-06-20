package aw.algorithms.sorting.quicksort;

import org.junit.jupiter.api.BeforeEach;

import aw.algorithms.sorting.SortingAlgorithmTestBase;

public class QuickSortTest extends SortingAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getQuickSort();
  }
}
