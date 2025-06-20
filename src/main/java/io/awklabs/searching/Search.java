package io.awklabs.searching;

import java.util.Comparator;

public interface Search<T> {

  int search(int[] array, int key);

  int search(T[] array, T key, Comparator<? super T> c);
}
