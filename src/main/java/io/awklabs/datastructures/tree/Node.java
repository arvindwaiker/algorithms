package io.awklabs.datastructures.tree;

public class Node<T> {

    T element;
    Node<T> left;
    Node<T> right;

    public Node(T element) {
        this(element, null, null);
    }

    public Node(T element, Node left, Node right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
