package io.awklabs.sorting;

import java.util.Comparator;
import java.util.List;

public interface Sort<T> {

	public void sort(int[] array);

	public void sort(T[] array, Comparator<? super T> c);
}
