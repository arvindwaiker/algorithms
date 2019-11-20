package io.awklabs.sorting.mergesort;

import io.awklabs.sorting.SortingAlgorithmTestHarness;

public class MergeSortTest extends SortingAlgorithmTestHarness {

    @Override
    public void before() {
        super.before();
        sort = factory.getMergeSort();
    }
}