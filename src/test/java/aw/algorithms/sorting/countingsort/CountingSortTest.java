package aw.algorithms.sorting.countingsort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aw.algorithms.sorting.SortingAlgorithmTestBase;

public class CountingSortTest extends SortingAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getCountingSort();
  }

  @Test
  public void testIntSort() {
    // Overriding implementation for Counting Sort as counting sort only works for a specified
    // range.
    // We have a range from 0 - 9
    int[] array = {1, 4, 1, 2, 7, 5, 2};
    int[] expected = {1, 1, 2, 2, 4, 5, 7};
    sort.sort(array);
    assertArrayEquals(expected, array);
  }

  @Test
  public void testIntSortGreaterThan128() {
    int[] array = {19, 94, 100, 128, 87, 59, 32};
    assertThrows(RuntimeException.class, () -> sort.sort(array));
  }

  @Override
  @Test
  public void testStringSort() {
    assertThrows(RuntimeException.class, super::testStringSort);
  }

  @Override
  @Test
  public void testEmptyStringArray() {
    assertThrows(RuntimeException.class, super::testEmptyStringArray);
  }

  @Override
  @Test
  public void testNullComparator() {
    assertThrows(RuntimeException.class, () -> sort.sort(new String[] {}, null));
  }

  @Override
  @Test
  public void testNullArray() {
    assertThrows(RuntimeException.class, () -> sort.sort(null, String::compareTo));
  }
}
