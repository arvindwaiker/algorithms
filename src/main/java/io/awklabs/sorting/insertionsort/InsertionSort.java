package io.awklabs.sorting.insertionsort;

import java.util.Comparator;

import io.awklabs.sorting.Sort;

public class InsertionSort<T> implements Sort<T> {

  @Override
  public void sort(int[] array) {
    assert array != null;

    int n = array.length;

    if (n <= 1) {
      return;
    }

    for (int i = 1; i < n; i++) {
      int key = array[i];
      int j = i - 1;

      while (j >= 0 && array[j] > key) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = key;
    }
  }

  @Override
  public void sort(T[] array, Comparator<? super T> c) {
    assert array != null && c != null;

    int n = array.length;

    if (n <= 1) {
      return;
    }

    for (int i = 1; i < n; i++) {
      T key = array[i];
      int j = i - 1;

      while (j >= 0 && c.compare(array[j], key) > 0) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = key;
    }
  }
}
