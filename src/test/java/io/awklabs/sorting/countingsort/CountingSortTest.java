package io.awklabs.sorting.countingsort;

import io.awklabs.sorting.SortingAlgorithmTestHarness;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CountingSortTest extends SortingAlgorithmTestHarness {

    @Override
    public void before() {
        super.before();
        sort = factory.getCountingSort();
    }

    @Override
    public void testIntSort() {
        //Overriding implementation for Counting Sort as counting sort only works for a specified range.
        //We have a range from 0 - 9
        int[] array = {1, 4, 1, 2, 7, 5, 2};
        int[] expected = {1, 1, 2, 2, 4, 5, 7};
        sort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test(expected = RuntimeException.class)
    public void testIntSortGreaterThan128() {
        int[] array = {19, 94, 100, 128, 87, 59, 32};
        sort.sort(array);
    }

    @Override
    @Test(expected = RuntimeException.class)
    public void testStringSort() {
        super.testStringSort();
    }
}