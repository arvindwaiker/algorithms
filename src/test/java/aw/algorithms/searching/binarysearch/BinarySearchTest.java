package aw.algorithms.searching.binarysearch;

import org.junit.jupiter.api.BeforeEach;

import aw.algorithms.searching.SearchAlgorithmTestBase;

public class BinarySearchTest extends SearchAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    search = factory.getBinarySearch();
  }
}
