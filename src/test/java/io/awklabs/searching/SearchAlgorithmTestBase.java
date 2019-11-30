package io.awklabs.searching;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class SearchAlgorithmTestBase {

    protected SearchAlgorithmFactory factory;

    protected Search<String> search;

    @Before
    public void before() {
        factory = SearchAlgorithmFactory.getInstance();
    }

    @Test
    public void testIntSearch() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 7;
        assertEquals(6, search.search(data, key));

        int[] data1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key1 = 6;
        assertEquals(5, search.search(data1, key1));
    }

    @Test
    public void testIntSearchKeyNotPresent() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 11;
        assertEquals(-1, search.search(data, key));
    }

    @Test
    public void testStringSearch() {
        String[] data = {"Chandler", "Joey", "Monica", "Rachel", "Ross", "Pheobe"};
        String key = "Monica";
        assertEquals(2, search.search(data, key, String::compareTo));

        String[] data1 = {"Chandler", "Joey", "Monica", "Rachel", "Ross", "Pheobe"};
        String key1 = "Rachel";
        assertEquals(3, search.search(data1, key1, String::compareTo));
    }

    @Test
    public void testStringSearchKeyNotPresent() {
        String[] data = {"Chandler", "Joey", "Monica", "Rachel", "Ross", "Pheobe"};
        String key = "Gunther";
        assertEquals(-1, search.search(data, key, String::compareTo));
    }

    @Test(expected = AssertionError.class)
    public void testNullIntArray() {
        search.search(null, 0);
    }

    @Test(expected = AssertionError.class)
    public void testNullArray() {
        search.search(null, null, null);
    }

}
