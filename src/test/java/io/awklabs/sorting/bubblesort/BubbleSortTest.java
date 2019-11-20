package io.awklabs.sorting.bubblesort;

import io.awklabs.sorting.SortingAlgorithmTestHarness;
import org.junit.Before;

public class BubbleSortTest extends SortingAlgorithmTestHarness {

    @Before
    public void before() {
        super.before();
        sort = factory.getBubbleSort();
    }
}