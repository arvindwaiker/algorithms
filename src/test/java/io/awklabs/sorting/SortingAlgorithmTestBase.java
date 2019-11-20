package io.awklabs.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public abstract class SortingAlgorithmTestBase {

    protected SortingAlgorithmFactory factory;

    protected Sort<String> sort;

    @Before
    public void before() {
        factory = SortingAlgorithmFactory.getInstance();
    }

    @Test
    public void testIntSort() {
        int[] array = {5, 6, 7, 1, 2, 8, 3, 10, 4, 9};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testStringSort() {
        String[] strings = {"Rachel", "Monica", "Ross", "Chandler", "Joey", "Phoebe"};
        String[] expected = {"Chandler", "Joey", "Monica", "Phoebe", "Rachel", "Ross"};
        sort.sort(strings, String::compareTo);
        assertArrayEquals(expected, strings);
    }
}
