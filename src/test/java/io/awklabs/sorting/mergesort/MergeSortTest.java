package io.awklabs.sorting.mergesort;

import io.awklabs.sorting.SortingAlgorithmTestHarness;

import static org.junit.Assert.*;

public class MergeSortTest extends SortingAlgorithmTestHarness {

    @Override
    public void before() {
        super.before();
        sort = factory.getMergeSort();
    }
}