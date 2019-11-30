package io.awklabs.datastructures.binarytree;

import java.util.Comparator;
import java.util.List;

public class BinarySearchTree<T> {

    public Node<T> insert(Node<T> root, T element, Comparator<? super T> c) {
        assert element != null;

        if (root == null) {
            return new Node<>(element);
        }

        if (c.compare(root.element, element) > 0) {
            root.left = insert(root.left, element, c);
        } else if (c.compare(root.element, element) < 0) {
            root.right = insert(root.right, element, c);
        }
        return root;
    }

    public Node<T> search(Node<T> root, T element, Comparator<? super T> c) {
        assert element != null;

        if (root == null || c.compare(root.element, element) == 0) {
            return root;
        }

        if (c.compare(root.element, element) > 0) {
            return search(root.left, element, c);
        } else {
            return search(root.right, element, c);
        }
    }

    public void inOrder(Node<T> node, List<T> resultArray) {

        if (node == null) {
            return;
        }

        inOrder(node.left, resultArray);
        resultArray.add(node.element);
        inOrder(node.right, resultArray);
    }
}
