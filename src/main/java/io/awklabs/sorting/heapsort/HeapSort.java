package io.awklabs.sorting.heapsort;

import io.awklabs.sorting.Sort;

import java.util.Comparator;

public class HeapSort<T> implements Sort<T> {

    @Override
    public void sort(int[] array) {

        assert array != null;

        int n = array.length;

        if (n <= 1) {
            return;
        }

        for (int i = (n / 2) - 1; i >= 0; i--)
            heapify(array, n, i);


        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }

    }

    private void heapify(int[] array, int n, int i) {

        int largest = i;
        int l = (2 * i) + 1;
        int r = (2 * i) + 2;

        if (l < n && array[l] > array[largest])
            largest = l;

        if (r < n && array[r] > array[largest])
            largest = r;

        if (largest != i) {

            int temp = array[largest];
            array[largest] = array[i];
            array[i] = temp;

            heapify(array, n, largest);
        }

    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {

        assert array != null && c != null;

        int n = array.length;

        if (n <= 1)
            return;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(array, n, i, c);
        }

        for (int i = n - 1; i >= 0; i--) {

            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0, c);

        }

    }

    private void heapify(T[] array, int n, int i, Comparator<? super T> c) {

        int largest = i;
        int l = (2 * i) + 1;
        int r = (2 * i) + 2;

        if (l < n && c.compare(array[l], array[largest]) > 0)
            largest = l;

        if (r < n && c.compare(array[r], array[largest]) > 0)
            largest = r;

        if (largest != i) {
            T temp = array[largest];
            array[largest] = array[i];
            array[i] = temp;

            heapify(array, n, largest, c);
        }
    }
}
