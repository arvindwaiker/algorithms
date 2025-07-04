package aw.algorithms.sorting.shellsort;

import java.util.Comparator;

import aw.algorithms.sorting.Sort;

public class ShellSort<T> implements Sort<T> {

  @Override
  public void sort(int[] array) {

    assert array != null;

    int n = array.length;

    if (n <= 1) {
      return;
    }

    int h = 1;
    while (h < n / 3) {
      h = 3 * h + 1;
    }

    while (h >= 1) {
      for (int i = h; i < n; i++) {
        int key = array[i];
        int j = i;
        while (j >= h && array[j - h] > key) {
          array[j] = array[j - h];
          j -= h;
        }
        array[j] = key;
      }
      h = h / 3;
    }
  }

  @Override
  public void sort(T[] array, Comparator<? super T> c) {

    assert array != null && c != null;

    int n = array.length;

    if (n <= 1) {
      return;
    }

    int h = 1;
    while (h < n / 3) {
      h = 3 * h + 1;
    }

    while (h >= 1) {
      for (int i = h; i < n; i++) {
        T key = array[i];
        int j = i;
        while (j >= h && c.compare(array[j - h], key) > 0) {
          array[j] = array[j - h];
          j -= h;
        }
        array[j] = key;
      }
      h = h / 3;
    }
  }
}
