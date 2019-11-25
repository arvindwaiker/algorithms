package io.awklabs.sorting.bubblesort;

import io.awklabs.sorting.Sort;

import java.util.Comparator;

public class BubbleSort<T> implements Sort<T> {

    @Override
    public void sort(int[] array) {
        assert array != null;

        int n = array.length;

        if (n <= 0) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {
        assert array != null && c != null;

        int n = array.length;

        if (n <= 0) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (c.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
