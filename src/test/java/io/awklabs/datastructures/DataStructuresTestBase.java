package io.awklabs.datastructures;

import org.junit.jupiter.api.BeforeEach;

public abstract class DataStructuresTestBase {

  protected Integer[] data;

  @BeforeEach
  public void before() {
    data = new Integer[] {5, 6, 7, 1, 2, 8, 3, 10, 4, 9};
  }
}
