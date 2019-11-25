package io.awklabs.sorting.quicksort;

import io.awklabs.sorting.Sort;

import java.util.Comparator;

public class QuickSort<T> implements Sort<T> {

    @Override
    public void sort(int[] array) {
        assert array != null;

        int n = array.length;

        if (n <= 0) {
            return;
        }

        quickSort(array, 0, n - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {

        assert array != null && c != null;

        int n = array.length;

        if (n <= 0) {
            return;
        }
        quickSort(array, 0, n - 1, c);
    }

    private void quickSort(T[] array, int low, int high, Comparator<? super T> c) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, c);

            quickSort(array, low, pivotIndex - 1, c);
            quickSort(array, pivotIndex + 1, high, c);
        }
    }

    private int partition(T[] array, int low, int high, Comparator<? super T> c) {

        T pivot = array[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (c.compare(array[j], pivot) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;

    }
}
