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

    public Node<T> delete(Node<T> root, T element, Comparator<? super T> c) {

        if (root == null) {
            return root;
        }

        if (c.compare(root.element, element) > 0) {
            root.left = delete(root.left, element, c);
        } else if (c.compare(root.element, element) < 0) {
            root.right = delete(root.right, element, c);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //Do not actually delete the node. Instead replace it with min value. Delete the min value node in the right sub tree.
            root.element = (T) minValue(root.right, c);
            root.right = delete(root.right, root.element, c);
        }

        return root;

    }

    private T minValue(Node<T> root, Comparator<? super T> c) {
        T minv = root.element;
        while (root.left != null) {
            minv = (T) root.left.element;
            root = root.left;
        }
        return minv;
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
