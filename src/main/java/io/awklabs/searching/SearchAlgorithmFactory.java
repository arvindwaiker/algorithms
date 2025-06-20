package io.awklabs.searching;

import io.awklabs.searching.binarysearch.BinarySearch;
import io.awklabs.searching.jumpsearch.JumpSearch;

public class SearchAlgorithmFactory {

  private SearchAlgorithmFactory() {}

  public static SearchAlgorithmFactory getInstance() {
    return new SearchAlgorithmFactory();
  }

  public <T> BinarySearch<T> getBinarySearch() {
    return new BinarySearch<>();
  }

  public <T> JumpSearch<T> getJumpSearch() {
    return new JumpSearch<>();
  }
}
