package aw.algorithms.searching.jumpsearch;

import java.util.Comparator;

import aw.algorithms.searching.Search;

public class JumpSearch<T> implements Search<T> {
  @Override
  public int search(int[] array, int key) {
    assert array != null;

    int n = array.length;

    int blockSize = (int) Math.sqrt(n);

    int limit = -1;
    for (int i = 0; i < n; i += blockSize) {

      if (array[i] == key) {
        return i;
      }
      if (array[i] > key) {
        limit = i;
        break;
      }
    }

    for (int i = limit; i > limit - blockSize && limit >= 0; i--) {
      if (array[i] == key) {
        return i;
      }
    }

    return -1;
  }

  @Override
  public int search(T[] array, T key, Comparator<? super T> c) {
    assert array != null && key != null && c != null;

    int n = array.length;

    int blockSize = (int) Math.sqrt(n);

    int limit = -1;
    for (int i = 0; i < n; i += blockSize) {
      if (c.compare(array[i], key) == 0) {
        return i;
      }

      if (c.compare(array[i], key) > 0) {
        limit = i;
        break;
      }
    }

    for (int i = limit; i > limit - blockSize && limit >= 0; i--) {
      if (c.compare(array[i], key) == 0) {
        return i;
      }
    }

    return -1;
  }
}
