package aw.algorithms.sorting.mergesort;

import org.junit.jupiter.api.BeforeEach;

import aw.algorithms.sorting.SortingAlgorithmTestBase;

public class MergeSortTest extends SortingAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getMergeSort();
  }
}
