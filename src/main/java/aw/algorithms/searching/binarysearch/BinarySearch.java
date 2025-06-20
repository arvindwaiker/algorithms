package aw.algorithms.searching.binarysearch;

import java.util.Comparator;

import aw.algorithms.searching.Search;

public class BinarySearch<T> implements Search<T> {

  @Override
  public int search(int[] array, int key) {
    assert array != null;

    return binarySearch(array, key, 0, array.length - 1);
  }

  private int binarySearch(int[] array, int key, int low, int high) {
    if (low <= high) {
      int mid = (low + high) / 2;

      if (array[mid] == key) {
        return mid;
      } else if (array[mid] > key) {
        return binarySearch(array, key, low, mid - 1);
      } else {
        return binarySearch(array, key, mid + 1, high);
      }
    } else {
      return -1;
    }
  }

  @Override
  public int search(T[] array, T key, Comparator<? super T> c) {
    assert array != null && key != null && c != null;

    return binarySearch(array, key, 0, array.length - 1, c);
  }

  private int binarySearch(T[] array, T key, int low, int high, Comparator<? super T> c) {
    if (low <= high) {
      int mid = (low + high) / 2;

      if (array[mid].equals(key)) {
        return mid;
      } else if (c.compare(array[mid], key) > 0) {
        return binarySearch(array, key, low, mid - 1, c);
      } else {
        return binarySearch(array, key, mid + 1, high, c);
      }
    } else {
      return -1;
    }
  }
}
