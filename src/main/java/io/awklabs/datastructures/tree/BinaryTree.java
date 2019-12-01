package io.awklabs.datastructures.tree;

import io.awklabs.datastructures.queue.Queue;

import java.util.List;

public class BinaryTree<T> {

    public Node<T> insertInOrder(Node<T> root, T element) {
        if (root == null) {
            root = new Node<>(element);
            return root;
        }

        Queue<Node<T>> queue = new Queue<>();
        queue.enQueue(root);

        while (queue.size() > 0) {
            Node<T> node = queue.deQueue();

            if (node.left == null) {
                node.left = new Node<>(element);
                break;
            } else
                queue.enQueue(node.left);

            if (node.right == null) {
                node.right = new Node<>(element);
                break;
            } else
                queue.enQueue(node.right);
        }

        return root;
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
