package io.awklabs.sorting.bubblesort;

import io.awklabs.sorting.SortingAlgorithmTestBase;
import org.junit.Before;

public class BubbleSortTest extends SortingAlgorithmTestBase {

    @Before
    public void before() {
        super.before();
        sort = factory.getBubbleSort();
    }
}