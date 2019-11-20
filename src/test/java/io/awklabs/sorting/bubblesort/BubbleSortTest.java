package io.awklabs.sorting.bubblesort;

import io.awklabs.sorting.SortingAlgorithmTestHarness;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest extends SortingAlgorithmTestHarness {

    @Before
    public void before() {
        super.before();
        sort = factory.getBubbleSort();
    }
}