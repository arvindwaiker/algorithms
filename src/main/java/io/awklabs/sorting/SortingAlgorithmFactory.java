package io.awklabs.sorting;

import io.awklabs.sorting.bubblesort.BubbleSort;
import io.awklabs.sorting.insertionsort.InsertionSort;
import io.awklabs.sorting.selectionsort.SelectionSort;

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
}
