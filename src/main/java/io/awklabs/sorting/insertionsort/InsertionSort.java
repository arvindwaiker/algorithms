package io.awklabs.sorting.insertionsort;

import io.awklabs.sorting.Sort;

import java.util.Comparator;

public class InsertionSort<T> implements Sort<T> {

    @Override
    public void sort(int[] array) {
        int n = array.length;
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
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0 && c.compare(array[j],key) > 1) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
