package io.awklabs.searching.binarysearch;

import io.awklabs.searching.SearchAlgorithmTestBase;

import static org.junit.Assert.*;

public class BinarySearchTest extends SearchAlgorithmTestBase {

    @Override
    public void before() {
        super.before();
        search = factory.getBinarySearch();
    }
}