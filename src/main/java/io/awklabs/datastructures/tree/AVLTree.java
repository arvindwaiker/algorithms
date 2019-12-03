package io.awklabs.datastructures.tree;

import java.util.Comparator;

public class AVLTree<T> extends BinarySearchTree<T> {

    public AVLTree(Comparator<? super T> comparator) {
        super(comparator);
    }

    private Node<T> rightRotate(Node<T> y) {

        Node<T> x = y.left;

        Node<T> temp = x.right;
        x.right = y;
        y.left = temp;

        return x;
    }

    private Node<T> leftRotate(Node<T> x) {

        Node<T> y = x.right;

        Node<T> temp = y.left;
        y.left = x;
        x.right = temp;

        return y;
    }

    private int getBalance(Node<T> node) {
        return height(node.left) - height(node.right);
    }

    @Override
    public Node<T> insert(Node<T> root, T element) {
        assert element != null;

        root = super.insert(root, element);

        int balance = getBalance(root);

        if (balance > 1) {
            if (comparator.compare(element, root.left.element) < 0) {
                return rightRotate(root);
            } else if (comparator.compare(element, root.left.element) > 0) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }

        if (balance < -1) {
            if (comparator.compare(element, root.right.element) < 0) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            } else if (comparator.compare(element, root.right.element) > 0) {
                return leftRotate(root);
            }
        }

        return root;

    }
}
