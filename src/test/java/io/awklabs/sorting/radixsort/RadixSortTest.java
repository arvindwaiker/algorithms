package io.awklabs.sorting.radixsort;

import io.awklabs.sorting.SortingAlgorithmTestBase;
import org.junit.Test;

public class RadixSortTest extends SortingAlgorithmTestBase {

    @Override
    public void before() {
        super.before();
        sort = factory.getRadixSort();
    }

    @Override
    @Test(expected = RuntimeException.class)
    public void testStringSort() {
        super.testStringSort();
    }

    @Override
    @Test(expected = RuntimeException.class)
    public void testEmptyStringArray() {
        super.testEmptyStringArray();
    }

    @Override
    @Test(expected = RuntimeException.class)
    public void testNullComparator() {
        super.testNullComparator();
    }

    @Override
    @Test(expected = RuntimeException.class)
    public void testNullArray() {
        super.testNullArray();
    }
}
