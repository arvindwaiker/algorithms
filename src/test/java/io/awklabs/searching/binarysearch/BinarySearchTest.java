package io.awklabs.searching.binarysearch;

import io.awklabs.searching.SearchAlgorithmTestBase;

public class BinarySearchTest extends SearchAlgorithmTestBase {

    @Override
    public void before() {
        super.before();
        search = factory.getBinarySearch();
    }
}