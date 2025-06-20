package aw.algorithms.sorting.radixsort;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aw.algorithms.sorting.SortingAlgorithmTestBase;

public class RadixSortTest extends SortingAlgorithmTestBase {

  @Override
  @BeforeEach
  public void before() {
    super.before();
    sort = factory.getRadixSort();
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
