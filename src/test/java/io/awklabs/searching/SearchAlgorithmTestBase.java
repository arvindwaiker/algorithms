package io.awklabs.searching;

import io.awklabs.searching.SearchAlgorithmFactory;
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
        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 7;
        assertEquals(6,search.search(data,key));
    }

    @Test
    public void testIntSearchKeyNotPresent() {
        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 11;
        assertEquals(-1,search.search(data,key));
    }

    @Test
    public void testStringSearch() {
        String[] data = { "Chandler", "Joey", "Monica", "Rachel", "Ross", "Pheobe"};
        String key = "Monica";
        assertEquals(2,search.search(data, key, String::compareTo));
    }

    @Test
    public void testStringSearchKeyNotPresent() {
        String[] data = { "Chandler", "Joey", "Monica", "Rachel", "Ross", "Pheobe"};
        String key = "Gunther";
        assertEquals(-1,search.search(data, key, String::compareTo));
    }

}
