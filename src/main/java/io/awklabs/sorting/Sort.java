package io.awklabs.sorting;

import java.util.Comparator;

public interface Sort<T> {

	void sort(int[] array);

    void sort(T[] array, Comparator<? super T> c);
}
