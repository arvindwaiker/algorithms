package io.awklabs.sorting.selectionsort;

import io.awklabs.sorting.Sort;

import java.util.Comparator;

public class SelectionSort<T> implements Sort<T> {

    @Override
    public void sort(int[] array) {
        int n = array.length;

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

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int selectionIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (c.compare(array[selectionIndex], array[j]) > 1) {
                    selectionIndex = j;
                }
            }
            T temp = array[i];
            array[i] = array[selectionIndex];
            array[selectionIndex] = temp;
        }
    }
}
