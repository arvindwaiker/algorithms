package aw.algorithms.sorting.insertionsort;

import org.junit.jupiter.api.BeforeEach;

import aw.algorithms.sorting.SortingAlgorithmTestBase;

public class InsertionSortTest extends SortingAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getInsertionSort();
  }
}
