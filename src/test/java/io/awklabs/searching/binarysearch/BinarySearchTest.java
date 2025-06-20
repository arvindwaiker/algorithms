package io.awklabs.searching.binarysearch;

import org.junit.jupiter.api.BeforeEach;

import io.awklabs.searching.SearchAlgorithmTestBase;

public class BinarySearchTest extends SearchAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    search = factory.getBinarySearch();
  }
}
