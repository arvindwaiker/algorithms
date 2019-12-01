package io.awklabs.datastructures.tree;

public class Node<T> {

    T element;
    Node left;
    Node right;

    public Node(T element) {
        this(element, null, null);
    }

    public Node(T element, Node left, Node right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
