package aw.algorithms.sorting;

import aw.algorithms.sorting.bubblesort.BubbleSort;
import aw.algorithms.sorting.countingsort.CountingSort;
import aw.algorithms.sorting.heapsort.HeapSort;
import aw.algorithms.sorting.insertionsort.InsertionSort;
import aw.algorithms.sorting.mergesort.MergeSort;
import aw.algorithms.sorting.quicksort.QuickSort;
import aw.algorithms.sorting.radixsort.RadixSort;
import aw.algorithms.sorting.selectionsort.SelectionSort;
import aw.algorithms.sorting.shellsort.ShellSort;

public class SortingAlgorithmFactory {

  private SortingAlgorithmFactory() {}

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
