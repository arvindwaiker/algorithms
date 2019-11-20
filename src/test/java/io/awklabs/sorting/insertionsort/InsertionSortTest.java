package io.awklabs.sorting.insertionsort;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class InsertionSortTest extends SortingAlgorithmTestBase {

    @Override
    public void before() {
        super.before();
        sort = factory.getInsertionSort();
    }
}