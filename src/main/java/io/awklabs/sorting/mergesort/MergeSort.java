package io.awklabs.sorting.mergesort;

import io.awklabs.sorting.Sort;

import java.util.Comparator;

public class MergeSort<T> implements Sort<T> {

    @Override
    public void sort(int[] array) {
        mergesort(array, 0 , array.length - 1);
    }

    private void mergesort(int[] array, int left, int right) {

        if(left < right) {

            int middle = (left + right) / 2;

            mergesort(array, left, middle);
            mergesort(array, middle + 1, right);
            merge(array, left, middle, right);
        }

    }

    private void merge(int[] array, int left, int middle, int right) {

    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {

    }

    private void mergesort(T[] array, int left, int right) {

        if(left < right) {

            int middle = (left + right) / 2;

            mergesort(array, left, middle);
            mergesort(array, middle + 1, right);
            merge(array, left, middle, right);
        }

    }

    private void merge(T[] array, int left, int middle, int right) {

    }

}
