package aw.algorithms.sorting.selectionsort;

import java.util.Comparator;

import aw.algorithms.sorting.Sort;

public class SelectionSort<T> implements Sort<T> {

  @Override
  public void sort(int[] array) {

    assert array != null;

    int n = array.length;

    if (n <= 0) {
      return;
    }

    for (int i = 0; i < n - 1; i++) {
      int selectionIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (array[j] < array[selectionIndex]) {
          selectionIndex = j;
        }
      }
      int temp = array[i];
      array[i] = array[selectionIndex];
      array[selectionIndex] = temp;
    }
  }

  @Override
  public void sort(T[] array, Comparator<? super T> c) {

    assert array != null && c != null;

    int n = array.length;

    if (n <= 1) {
      return;
    }

    for (int i = 0; i < n - 1; i++) {
      int selectionIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (c.compare(array[selectionIndex], array[j]) > 0) {
          selectionIndex = j;
        }
      }
      T temp = array[i];
      array[i] = array[selectionIndex];
      array[selectionIndex] = temp;
    }
  }
}
