package io.awklabs.searching.jumpsearch;

import io.awklabs.searching.SearchAlgorithmTestBase;

public class JumpSearchTest extends SearchAlgorithmTestBase {

    @Override
    public void before() {
        super.before();
        search = factory.getJumpSearch();
    }
}
