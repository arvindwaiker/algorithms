package io.awklabs.datastructures.tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import io.awklabs.datastructures.DataStructuresTestBase;

public class BinaryTreeTest extends DataStructuresTestBase {

  private BinaryTree<Integer> binaryTree = new BinaryTree<>();

  @Test
  public void testInOrderTraversal() {
    Node<Integer> node = new Node<>(20);
    Stream.of(data).forEach(e -> binaryTree.insertInOrder(node, e));
    List<Integer> integers = new ArrayList<>();
    binaryTree.inOrder(node, integers);
    Integer[] expected = {3, 7, 10, 5, 4, 1, 9, 20, 2, 6, 8};
    assertArrayEquals(expected, integers.toArray(new Integer[11]));
  }

  @Test
  public void testEmptyBinaryTree() {
    Node<Integer> node = binaryTree.insertInOrder(null, 12);
    assertEquals(Integer.valueOf(12), node.element);
    assertNull(node.left);
    assertNull(node.right);
  }
}
