package io.awklabs.sorting.mergesort;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class MergeSortTest extends SortingAlgorithmTestBase {

    @Override
    public void before() {
        super.before();
        sort = factory.getMergeSort();
    }
}