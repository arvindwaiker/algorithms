package io.awklabs.datastructures.tree.rbtree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.awklabs.datastructures.DataStructuresTestBase;

public class RedBlackTreeTest extends DataStructuresTestBase {

  RedBlackTree<Integer> redBlackTree;

  @BeforeEach
  public void before() {
    super.before();
    redBlackTree = new RedBlackTree<>(Integer::compareTo);
  }

  @Test
  public void testInsert() {
    Stream.of(data).forEach(redBlackTree::insert);
    redBlackTree.insert(3);
    List<Node<Integer>> result = new ArrayList<>();
    redBlackTree.inOrder(redBlackTree.root(), result);
    Integer[] expectedValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Colour[] expectedColours = {
      Colour.BLACK,
      Colour.RED,
      Colour.BLACK,
      Colour.BLACK,
      Colour.BLACK,
      Colour.BLACK,
      Colour.BLACK,
      Colour.BLACK,
      Colour.RED,
      Colour.BLACK
    };

    assertEquals(expectedValues.length, result.size(), "Result size mismatch");

    for (int i = 0; i < expectedValues.length; i++) {
      assertEquals(expectedValues[i], result.get(i).element, "Value mismatch at index " + i);
      assertEquals(expectedColours[i], result.get(i).colour, "Color mismatch at index " + i);
    }
  }
}
