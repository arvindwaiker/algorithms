package io.awklabs.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Non growing fixed size linked list implementation. Maximum size supported is 256.
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T> {

    Node<T> head;

    Node<T> tail;

    private int maximumSize;

    private int elementsCount;

    public LinkedList() {
        this(256);
    }

    public LinkedList(int initialCapacity) {
        this.maximumSize = initialCapacity;
        if (this.maximumSize > 256) {
            maximumSize = 256;
        }
        this.head = null;
        this.tail = null;
    }

    public void insertAtLast(T element) {
        assert element != null;

        if (elementsCount >= maximumSize) {
            throw new RuntimeException("Linked List Full");
        }

        Node<T> node = new Node<>(element);
        elementsCount++;
        if (head == null && tail == null) {
            head = tail = node;
            return;
        }

        if (head == tail) {
            head.next = node;
        }

        tail.next = node;
        node.previous = tail;
        tail = node;
    }

    public void deleteFromLast() {
        if (elementsCount != 0) {
            tail = tail.previous;
            tail.next = null;
            elementsCount--;
        }
    }

    public void deleteFromFirst() {
        if (elementsCount != 0) {
            head = head.next;
            head.previous = null;
            elementsCount--;
        }
    }

    public int size() {
        return elementsCount;
    }

    public int capacity() {
        return maximumSize;
    }

    public List<T> asList() {
        List<T> elementsList = new ArrayList<>();
        forEach(elementsList::add);
        return elementsList;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(this.head);
    }


    private class LinkedListIterator implements Iterator<T> {

        Node<T> currentNode;

        public LinkedListIterator(Node<T> head) {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (currentNode == null) {
                throw new NoSuchElementException("Reached end of Linked List");
            }
            T element = currentNode.element;
            currentNode = currentNode.next;
            return element;
        }
    }
}
