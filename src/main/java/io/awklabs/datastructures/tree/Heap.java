package io.awklabs.datastructures.tree;

import java.util.Comparator;

public class Heap<T> {

    private T[] elements;

    private int maximumSize;

    private int elementsCount;

    private boolean minHeap;

    private Comparator<? super T> comparator;

    public Heap(int initialCapacity, boolean minHeap, Comparator<? super T> c) {
        maximumSize = initialCapacity;
        if (maximumSize > 256) {
            maximumSize = 256;
        }
        elements = (T[]) new Object[maximumSize];
        elementsCount = 0;
        this.minHeap = minHeap;
        this.comparator = c;
    }

    public void heapify(int i) {

        int largest = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        if (left < elementsCount
                && ((!minHeap && comparator.compare(elements[left], elements[largest]) > 0)
                || (minHeap && comparator.compare(elements[left], elements[largest]) < 0))
        ) {
            largest = left;
        }

        if (right < elementsCount
                && ((!minHeap && comparator.compare(elements[right], elements[largest]) > 0)
                || (minHeap && comparator.compare(elements[right], elements[largest]) < 0))
        ) {
            largest = right;
        }

        if (largest != i) {
            T temp = elements[largest];
            elements[largest] = elements[i];
            elements[i] = temp;

            heapify(largest);
        }
    }

    public void insertKey(T element) {
        if (elementsCount == maximumSize) {
            throw new RuntimeException("Heap Full");
        }

        int i = elementsCount++;
        elements[i] = element;

        while (i != 0 &&
                ((minHeap && comparator.compare(elements[parent(i)], elements[i]) > 0) ||
                        (!minHeap && comparator.compare(elements[parent(i)], elements[i]) < 0))) {
            T temp = elements[i];
            elements[i] = elements[parent(i)];
            elements[parent(i)] = temp;
            i = parent(i);
        }
    }

    public T[] getElements() {
        T[] copy = (T[]) new Object[elementsCount];
        System.arraycopy(elements, 0, copy, 0, elementsCount);
        return copy;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }
}
