package io.awklabs.sorting.insertionsort;

import io.awklabs.sorting.SortingAlgorithmTestHarness;

public class InsertionSortTest extends SortingAlgorithmTestHarness {

    @Override
    public void before() {
        super.before();
        sort = factory.getInsertionSort();
    }
}