package io.awklabs.searching;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class SearchAlgorithmTestBase {

  protected SearchAlgorithmFactory factory;

  protected Search<String> search;

  @BeforeEach
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

    String key1 = "Rachel";
    assertEquals(3, search.search(data, key1, String::compareTo));
  }

  @Test
  public void testStringSearchKeyNotPresent() {
    String[] data = {"Chandler", "Joey", "Monica", "Rachel", "Ross", "Pheobe"};
    String key = "Gunther";
    assertEquals(-1, search.search(data, key, String::compareTo));
  }

  @Test
  public void testNullIntArray() {
    assertThrows(AssertionError.class, () -> search.search(null, 0));
  }

  @Test
  public void testNullArray() {
    assertThrows(AssertionError.class, () -> search.search(null, null, null));
  }
}
