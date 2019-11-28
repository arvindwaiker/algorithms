package io.awklabs.sorting.radixsort;

import io.awklabs.sorting.Sort;

import java.util.Comparator;
import java.util.stream.IntStream;

public class RadixSort<T> implements Sort<T> {
    @Override
    public void sort(int[] array) {

        assert array != null;

        int n = array.length;

        if (n <= 1) {
            return;
        }

        int max = IntStream.of(array).max().getAsInt();

        for (int e = 1; max / e > 0; e *= 10) {
            countSort(array, n, e);
        }

    }

    private void countSort(int[] array, int n, int e) {
        int[] sortedArray = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(array[i] / e) % 10]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = count[(array[i] / e) % 10]--;
            sortedArray[index - 1] = array[i];
        }

        System.arraycopy(sortedArray, 0, array, 0, n);

    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {
        throw new RuntimeException("Radix sort is only designed for Integers");
    }
}
