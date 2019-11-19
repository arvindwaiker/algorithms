package io.awklabs.sorting;

public class SortingAlgorithmFactory {

	private SortingAlgorithmFactory() {

	}

	public static SortingAlgorithmFactory getInstance() {
		return new SortingAlgorithmFactory();
	}

	public <T> BubbleSort<T> getBubbleSort() {
		return new BubbleSort<T>();
	}
}
