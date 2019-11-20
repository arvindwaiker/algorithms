package io.awklabs.sorting.selectionsort;

import io.awklabs.sorting.SortingAlgorithmTestHarness;

public class SelectionSortTest extends SortingAlgorithmTestHarness {

    @Override
    public void before() {
        super.before();
        sort = factory.getSelectionSort();
    }
}