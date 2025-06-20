package aw.algorithms.sorting.selectionsort;

import org.junit.jupiter.api.BeforeEach;

import aw.algorithms.sorting.SortingAlgorithmTestBase;

public class SelectionSortTest extends SortingAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getSelectionSort();
  }
}
