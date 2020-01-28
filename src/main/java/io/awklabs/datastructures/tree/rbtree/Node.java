package io.awklabs.datastructures.tree.rbtree;

public class Node<T> {

    T element;

    Node<T> left;

    Node<T> right;

    Colour colour;

    public Node(T element) {
        this.element = element;
        this.colour = Colour.RED;
    }

    @Override
    public String toString() {
        return element + "(" + colour + ")";
    }
}
