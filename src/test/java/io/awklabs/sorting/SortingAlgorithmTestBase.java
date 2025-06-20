package io.awklabs.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class SortingAlgorithmTestBase {

  protected SortingAlgorithmFactory factory;

  protected Sort<String> sort;

  @BeforeEach
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

  @Test
  public void testNullArray() {
    assertThrows(AssertionError.class, () -> sort.sort(null, String::compareTo));
  }

  @Test
  public void testNullIntArray() {
    assertThrows(AssertionError.class, () -> sort.sort(null));
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

  @Test
  public void testNullComparator() {
    assertThrows(AssertionError.class, () -> sort.sort(new String[] {}, null));
  }
}
