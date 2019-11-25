package io.awklabs.sorting.countingsort;

import io.awklabs.sorting.Sort;

import java.util.Comparator;

public class CountingSort<T> implements Sort<T> {

    /**
     * Counting sort algorithm implementation. Supports 0-127
     *
     * @param array The input array to be sorted
     */
    @Override
    public void sort(int[] array) {
        assert array != null;

        int n = array.length;

        if (n <= 0) {
            return;
        }

        int[] countingArray = new int[128];

        for (int element : array) {
            if (element > 127) {
                throw new RuntimeException("Counting support only supported for range of 0 - 127. Not Supported yet!");
            }
            countingArray[element]++;
        }

        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i] + countingArray[i - 1];
        }

        int[] sortedArray = new int[n];
        for (int element : array) {
            int index = countingArray[element]--;
            sortedArray[index - 1] = element;
        }

        System.arraycopy(sortedArray, 0, array, 0, n);

    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {
        throw new RuntimeException("Counting sort is only designed for Integers");
    }
}
