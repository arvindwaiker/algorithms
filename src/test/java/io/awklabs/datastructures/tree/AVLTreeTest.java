package io.awklabs.datastructures.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.awklabs.datastructures.DataStructuresTestBase;

public class AVLTreeTest extends DataStructuresTestBase {

  AVLTree<Integer> avlTree;

  @Override
  @BeforeEach
  public void before() {
    super.before();
    avlTree = new AVLTree<>(Integer::compareTo);
  }

  @Test
  public void testInsert() {
    Node<Integer> root = null;
    for (int element : Arrays.asList(5, 4, 3, 6, 7, 1, 2, 9, 8)) {
      root = avlTree.insert(root, element);
    }

    root = avlTree.insert(root, 9); // Duplicate entry shall be ignored.

    List<Integer> expectedInOrder = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    List<Integer> expectedPreOrder = Arrays.asList(4, 2, 1, 3, 6, 5, 8, 7, 9);
    List<Integer> expectedPostOrder = Arrays.asList(1, 3, 2, 5, 7, 9, 8, 6, 4);

    List<Integer> result = new ArrayList<>();
    avlTree.inOrder(root, result);
    assertEquals(expectedInOrder, result);
    result = new ArrayList<>();
    avlTree.preOrder(root, result);
    assertEquals(expectedPreOrder, result);
    result = new ArrayList<>();
    avlTree.postOrder(root, result);
    assertEquals(expectedPostOrder, result);
  }

  @Test
  public void testDeleteOnlyOneElement() {
    Node<Integer> root = avlTree.insert(null, 10);
    avlTree.delete(root, 10);
  }

  @Test
  public void testDeleteLeftRotate() {
    Node<Integer> root = null;
    for (int element : Arrays.asList(10, 9, 11, 12)) {
      root = avlTree.insert(root, element);
    }

    root = avlTree.delete(root, 9);

    List<Integer> expectedInOrder = Arrays.asList(10, 11, 12);
    List<Integer> expectedPreOrder = Arrays.asList(11, 10, 12);
    List<Integer> expectedPostOrder = Arrays.asList(10, 12, 11);

    List<Integer> result = new ArrayList<>();
    avlTree.inOrder(root, result);
    assertEquals(expectedInOrder, result);
    result = new ArrayList<>();
    avlTree.preOrder(root, result);
    assertEquals(expectedPreOrder, result);
    result = new ArrayList<>();
    avlTree.postOrder(root, result);
    assertEquals(expectedPostOrder, result);
  }

  @Test
  public void testDeleteRightRotate() {
    Node<Integer> root = null;
    for (int element : Arrays.asList(11, 10, 12, 9)) {
      root = avlTree.insert(root, element);
    }

    root = avlTree.delete(root, 12);

    List<Integer> expectedInOrder = Arrays.asList(9, 10, 11);
    List<Integer> expectedPreOrder = Arrays.asList(10, 9, 11);
    List<Integer> expectedPostOrder = Arrays.asList(9, 11, 10);

    List<Integer> result = new ArrayList<>();
    avlTree.inOrder(root, result);
    assertEquals(expectedInOrder, result);
    result = new ArrayList<>();
    avlTree.preOrder(root, result);
    assertEquals(expectedPreOrder, result);
    result = new ArrayList<>();
    avlTree.postOrder(root, result);
    assertEquals(expectedPostOrder, result);
  }

  @Test
  public void testDeleteLeftRightRotate() {
    Node<Integer> root = null;
    for (int element : Arrays.asList(4, 2, 8, 3)) {
      root = avlTree.insert(root, element);
    }

    root = avlTree.delete(root, 8);

    List<Integer> expectedInOrder = Arrays.asList(2, 3, 4);
    List<Integer> expectedPreOrder = Arrays.asList(3, 2, 4);
    List<Integer> expectedPostOrder = Arrays.asList(2, 4, 3);

    List<Integer> result = new ArrayList<>();
    avlTree.inOrder(root, result);
    assertEquals(expectedInOrder, result);
    result = new ArrayList<>();
    avlTree.preOrder(root, result);
    assertEquals(expectedPreOrder, result);
    result = new ArrayList<>();
    avlTree.postOrder(root, result);
    assertEquals(expectedPostOrder, result);
  }

  @Test
  public void testDeleteRightLeftRotate() {
    Node<Integer> root = null;
    for (int element : Arrays.asList(4, 2, 8, 6)) {
      root = avlTree.insert(root, element);
    }

    root = avlTree.delete(root, 2);

    List<Integer> expectedInOrder = Arrays.asList(4, 6, 8);
    List<Integer> expectedPreOrder = Arrays.asList(6, 4, 8);
    List<Integer> expectedPostOrder = Arrays.asList(4, 8, 6);

    List<Integer> result = new ArrayList<>();
    avlTree.inOrder(root, result);
    assertEquals(expectedInOrder, result);
    result = new ArrayList<>();
    avlTree.preOrder(root, result);
    assertEquals(expectedPreOrder, result);
    result = new ArrayList<>();
    avlTree.postOrder(root, result);
    assertEquals(expectedPostOrder, result);
  }
}
