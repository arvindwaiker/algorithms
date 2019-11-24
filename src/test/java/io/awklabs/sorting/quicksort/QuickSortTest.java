package io.awklabs.sorting.quicksort;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class QuickSortTest extends SortingAlgorithmTestBase {

    @Override
    public void before() {
        super.before();
        sort = factory.getQuickSort();
    }
}