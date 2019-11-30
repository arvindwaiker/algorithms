package io.awklabs.datastructures.binarytree;

import io.awklabs.datastructures.DataStructuresTestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTreeTest extends DataStructuresTestBase {

    private BinarySearchTree<Integer> binarySearchTree;

    @Override
    public void before() {
        super.before();
        binarySearchTree = new BinarySearchTree<>();
    }

    @Test
    public void testBSTInsert() {
        Node<Integer> root = null;
        for (int element : data) {
            root = binarySearchTree.insert(root, element, Integer::compareTo);
        }
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> result = new ArrayList<>();
        binarySearchTree.inOrder(root, result);
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testBSTSearch() {
        Node<Integer> root = null;
        for (int element : data) {
            root = binarySearchTree.insert(root, element, Integer::compareTo);
        }

        assertEquals(Integer.valueOf(10), binarySearchTree.search(root, 10, Integer::compareTo).element);
        assertEquals(Integer.valueOf(3), binarySearchTree.search(root, 3, Integer::compareTo).element);
        assertNull(binarySearchTree.search(root, 20, Integer::compareTo));
    }
}