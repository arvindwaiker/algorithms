package io.awklabs.sorting.countingsort;

import java.util.Comparator;

import io.awklabs.sorting.Sort;

public class CountingSort<T> implements Sort<T> {

  /**
   * Counting sort algorithm implementation. Supports 0-127
   *
   * @param array The input array to be sorted
   */
  @Override
  public void sort(int[] array) {
    assert array != null;

    int n = array.length;

    if (n <= 1) {
      return;
    }

    int[] countingArray = new int[128];

    for (int element : array) {
      if (element > 127) {
        throw new RuntimeException(
            "Counting support only supported for range of 0 - 127. Not Supported yet!");
      }
      countingArray[element]++;
    }

    for (int i = 1; i < countingArray.length; i++) {
      countingArray[i] = countingArray[i] + countingArray[i - 1];
    }

    int[] sortedArray = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      int index = countingArray[array[i]]--;
      sortedArray[index - 1] = array[i];
    }

    System.arraycopy(sortedArray, 0, array, 0, n);
  }

  @Override
  public void sort(T[] array, Comparator<? super T> c) {
    throw new RuntimeException("Counting sort is only designed for Integers");
  }
}
