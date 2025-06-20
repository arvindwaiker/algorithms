package aw.algorithms.searching.jumpsearch;

import org.junit.jupiter.api.BeforeEach;

import aw.algorithms.searching.SearchAlgorithmTestBase;

public class JumpSearchTest extends SearchAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    search = factory.getJumpSearch();
  }
}
