package io.awklabs.searching;

import io.awklabs.searching.binarysearch.BinarySearch;

public class SearchAlgorithmFactory {

    private SearchAlgorithmFactory() {

    }

    public static SearchAlgorithmFactory getInstance() {
        return new SearchAlgorithmFactory();
    }

    public <T> BinarySearch<T> getBinarySearch() {
        return new BinarySearch<>();
    }
}
