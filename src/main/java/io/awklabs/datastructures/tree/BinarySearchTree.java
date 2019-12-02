package io.awklabs.datastructures.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearchTree<T> {

    private Comparator<? super T> comparator;

    public BinarySearchTree(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public Node<T> insert(Node<T> root, T element) {
        assert element != null;

        if (root == null) {
            return new Node<>(element);
        }

        if (comparator.compare(root.element, element) > 0) {
            root.left = insert(root.left, element);
        } else if (comparator.compare(root.element, element) < 0) {
            root.right = insert(root.right, element);
        }
        return root;
    }

    public Node<T> search(Node<T> root, T element) {
        assert element != null;

        if (root == null || comparator.compare(root.element, element) == 0) {
            return root;
        }

        if (comparator.compare(root.element, element) > 0) {
            return search(root.left, element);
        } else {
            return search(root.right, element);
        }
    }

    public Node<T> delete(Node<T> root, T element) {

        if (root == null) {
            return root;
        }

        if (comparator.compare(root.element, element) > 0) {
            root.left = delete(root.left, element);
        } else if (comparator.compare(root.element, element) < 0) {
            root.right = delete(root.right, element);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //Do not actually delete the node. Instead replace it with min value. Delete the min value node in the right sub tree.
            root.element = (T) minValue(root.right);
            root.right = delete(root.right, root.element);
        }

        return root;

    }

    private T minValue(Node<T> root) {
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

    public void preOrder(Node<T> node, List<T> resultArray) {

        if (node == null) {
            return;
        }

        resultArray.add(node.element);
        preOrder(node.left, resultArray);
        preOrder(node.right, resultArray);
    }

    public void postOrder(Node<T> node, List<T> resultArray) {

        if (node == null) {
            return;
        }

        postOrder(node.left, resultArray);
        postOrder(node.right, resultArray);
        resultArray.add(node.element);
    }

    public Node<T> balance(Node<T> node) {

        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }

        List<T> result = new ArrayList<>();

        inOrder(node, result);

        return insert((T[]) result.toArray(), 0, result.size() - 1, null);

    }

    private Node<T> insert(T[] array, int low, int high, Node<T> root) {

        if (low == high) {
            root = insert(root, array[low]);
            return root;
        } else if (low > high) {
            return root;
        }

        int mid = (low + high) / 2;
        root = insert(root, array[mid]);
        root.left = insert(array, low, mid - 1, root.left);
        root.right = insert(array, mid + 1, high, root.right);

        return root;
    }

    public int height(Node<T> root) {

        if (root == null) {
            return 0;
        } else {

            int l = height(root.left);
            int r = height(root.right);
            if (l > r) {
                return l + 1;
            } else {
                return r + 1;
            }
        }
    }


}
