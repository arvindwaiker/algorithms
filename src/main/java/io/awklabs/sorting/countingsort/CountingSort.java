package io.awklabs.sorting.countingsort;

import io.awklabs.sorting.Sort;

import java.util.Comparator;

public class CountingSort<T> implements Sort<T> {

    /**
     * Counting sort algorithm implementation. Supports 0-127
     *
     * @param array
     */
    @Override
    public void sort(int[] array) {
        int n = array.length;

        int[] countingArray = new int[128];

        for (int i = 0; i < n; i++) {
            if (array[i] > 127) {
                throw new RuntimeException("Counting support only supported for range of 0 - 127. Not Supported yet!");
            }
            countingArray[array[i]]++;
        }

        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i] + countingArray[i - 1];
        }

        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            int index = countingArray[array[i]]--;
            sortedArray[index - 1] = array[i];
        }

        for (int i = 0; i < n; i++) {
            array[i] = sortedArray[i];
        }

    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {
        throw new RuntimeException("Counting sort is only designed for Integers");
    }
}
