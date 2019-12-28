package io.awklabs.sorting.shellsort;

import io.awklabs.sorting.SortingAlgorithmTestBase;

public class ShellSortTest extends SortingAlgorithmTestBase {

    @Override
    public void before() {
        super.before();
        sort = factory.getShellSort();
    }

}