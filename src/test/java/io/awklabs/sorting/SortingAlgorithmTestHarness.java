package io.awklabs.sorting;

import org.junit.Before;

public class SortingAlgorithmTestHarness {

    SortingAlgorithmFactory factory;

    @Before
    public void before() {
        factory = SortingAlgorithmFactory.getInstance();
    }
}
