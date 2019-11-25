package io.awklabs.sorting;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;

public abstract class SortingAlgorithmTestBase {

    @Rule
    public final ExpectedException expected = ExpectedException.none();

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

    @Test(expected = AssertionError.class)
    public void testNullArray() {
        sort.sort(null, String::compareTo);
    }

    @Test(expected = AssertionError.class)
    public void testNullIntArray() {
        sort.sort(null);
    }

    @Test
    public void testEmptyStringArray() {
        String[] strings = {};
        String[] expected = {};
        sort.sort(strings, String::compareTo);
        assertArrayEquals(expected, strings);
    }

    @Test
    public void testEmptyIntArray() {
        int[] array = {};
        int[] expected = {};
        sort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test(expected = AssertionError.class)
    public void testNullComparator() {
        sort.sort(new String[]{}, null);
    }
}
