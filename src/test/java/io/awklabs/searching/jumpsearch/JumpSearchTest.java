package io.awklabs.searching.jumpsearch;

import org.junit.jupiter.api.BeforeEach;

import io.awklabs.searching.SearchAlgorithmTestBase;

public class JumpSearchTest extends SearchAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    search = factory.getJumpSearch();
  }
}
