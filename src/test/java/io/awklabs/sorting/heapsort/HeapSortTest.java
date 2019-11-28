package io.awklabs.sorting.heapsort;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class HeapSortTest extends SortingAlgorithmTestBase {

    @Override
    public void before() {
        super.before();
        sort = factory.getHeapSort();
    }
}
