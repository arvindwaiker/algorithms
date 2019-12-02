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

    public T extractMinimumOrMaximum() {
        T result = elements[0];

        elements[0] = elements[elementsCount - 1];
        elements[elementsCount - 1] = null;
        elementsCount--;

        int i = 0;
        while (i < (elementsCount - 1) / 2) {
            int l = (2 * i) + 1;
            int r = l + 1;
            int smallest = l;
            if ((minHeap && comparator.compare(elements[l], elements[r]) > 0) || (!minHeap && comparator.compare(elements[l], elements[r]) < 0)) {
                smallest = r;
            }

            T temp = elements[i];
            elements[i] = elements[smallest];
            elements[smallest] = temp;

            i = smallest;
        }

        return result;
    }

    public T[] getElements() {
        T[] copy = (T[]) new Object[elementsCount];
        System.arraycopy(elements, 0, copy, 0, elementsCount);
        return copy;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    public int capacity() {
        return maximumSize;
    }
}
