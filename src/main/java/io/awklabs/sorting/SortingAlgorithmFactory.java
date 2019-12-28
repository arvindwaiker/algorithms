package io.awklabs.sorting;

import io.awklabs.sorting.bubblesort.BubbleSort;
import io.awklabs.sorting.countingsort.CountingSort;
import io.awklabs.sorting.heapsort.HeapSort;
import io.awklabs.sorting.insertionsort.InsertionSort;
import io.awklabs.sorting.mergesort.MergeSort;
import io.awklabs.sorting.quicksort.QuickSort;
import io.awklabs.sorting.radixsort.RadixSort;
import io.awklabs.sorting.selectionsort.SelectionSort;
import io.awklabs.sorting.shellsort.ShellSort;

public class SortingAlgorithmFactory {

    private SortingAlgorithmFactory() {

    }

    public static SortingAlgorithmFactory getInstance() {
        return new SortingAlgorithmFactory();
    }

    public <T> BubbleSort<T> getBubbleSort() {
        return new BubbleSort<>();
    }

    public <T> InsertionSort<T> getInsertionSort() {
        return new InsertionSort<>();
    }

    public <T> SelectionSort<T> getSelectionSort() {
        return new SelectionSort<>();
    }

    public <T> CountingSort<T> getCountingSort() {
        return new CountingSort<>();
    }

    public <T> MergeSort<T> getMergeSort() {
        return new MergeSort<>();
    }

    public <T> QuickSort<T> getQuickSort() {
        return new QuickSort<>();
    }

    public <T> HeapSort<T> getHeapSort() {
        return new HeapSort<>();
    }

    public <T> RadixSort<T> getRadixSort() {
        return new RadixSort<>();
    }

    public <T> ShellSort<T> getShellSort() {
        return new ShellSort<>();
    }
}
