package io.awklabs.datastructures.tree.rbtree;

import static io.awklabs.datastructures.tree.rbtree.Colour.BLACK;
import static io.awklabs.datastructures.tree.rbtree.Colour.RED;

import java.util.Comparator;
import java.util.List;

public class RedBlackTree<T> {

  private Node<T> root;

  private Comparator<? super T> comparator;

  public RedBlackTree(Comparator<? super T> comparator) {
    this.comparator = comparator;
    this.root = null;
  }

  public Node<T> root() {
    return root;
  }

  public void insert(T element) {
    root = insert(root, element);
    root.colour = BLACK;
  }

  public Node<T> insert(Node<T> root, T element) {
    if (root == null) return new Node<>(element);

    if (comparator.compare(root.element, element) < 0) {
      root.right = insert(root.right, element);
    } else if (comparator.compare(root.element, element) > 0) {
      root.left = insert(root.left, element);
    } else if (comparator.compare(root.element, element) == 0) {
      root.element = element;
    }

    if (isRed(root.right) && !isRed(root.left)) root = leftRotate(root);
    if (isRed(root.left) && isRed(root.left.left)) root = rightRotate(root);
    if (isRed(root.left) && isRed(root.right)) flipColours(root);

    return root;
  }

  private boolean isRed(Node<T> node) {
    if (node == null) return false; // Null node is considered BLACK.
    return node.colour == RED;
  }

  private void flipColours(Node<T> node) {
    assert !isRed(node);
    assert isRed(node.left);
    assert isRed(node.right);

    node.colour = RED;
    node.left.colour = BLACK;
    node.right.colour = BLACK;
  }

  private Node<T> leftRotate(Node<T> root) {
    assert isRed(root.right);
    Node x = root.right;
    root.right = x.left;
    x.left = root;
    x.colour = root.colour;
    root.colour = RED;
    return x;
  }

  private Node<T> rightRotate(Node<T> root) {
    assert isRed(root.left);
    Node x = root.left;
    root.left = x.right;
    x.right = root;
    x.colour = root.colour;
    root.colour = RED;
    return x;
  }

  public void inOrder(Node<T> node, List<Node<T>> resultArray) {

    if (node == null) {
      return;
    }

    inOrder(node.left, resultArray);
    resultArray.add(node);
    inOrder(node.right, resultArray);
  }
}
