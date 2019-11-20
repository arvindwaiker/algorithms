package io.awklabs.sorting.selectionsort;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class SelectionSortTest extends SortingAlgorithmTestBase {

    @Override
    public void before() {
        super.before();
        sort = factory.getSelectionSort();
    }
}