package io.awklabs.sorting.mergesort;

import io.awklabs.sorting.Sort;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class MergeSort<T> implements Sort<T> {

    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }

    }

    private void merge(int[] array, int left, int middle, int right) {

        int leftLength = middle - left + 1;
        int rightLength = right - middle;

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        System.arraycopy(array, left, leftArray, 0, leftLength);
        System.arraycopy(array, middle + 1, rightArray, 0, rightLength);

        int i = 0, j = 0;
        int k = left;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }

    }

    @Override
    public void sort(T[] array, Comparator<? super T> c) {
        mergeSort(array, c, 0, array.length - 1);
    }

    private void mergeSort(T[] array, Comparator<? super T> c, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(array, c, left, middle);
            mergeSort(array, c, middle + 1, right);
            merge(array, c, left, middle, right);
        }

    }

    private void merge(T[] array, Comparator<? super T> c, int left, int middle, int right) {

        int leftLength = middle - left + 1;
        int rightLength = right - middle;

        T[] leftArray = (T[]) new Object[leftLength];
        T[] rightArray = (T[]) new Object[rightLength];

        System.arraycopy(array, left, leftArray, 0, leftLength);
        System.arraycopy(array, middle + 1, rightArray, 0, rightLength);

        int i = 0, j = 0;
        int k = left;

        while (i < leftLength && j < rightLength) {
            if (c.compare(leftArray[i], rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

}
