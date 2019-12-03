package io.awklabs.datastructures.tree;

import io.awklabs.datastructures.DataStructuresTestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AVLTreeTest extends DataStructuresTestBase {

    AVLTree<Integer> avlTree;

    @Override
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

        root = avlTree.insert(root, 9); //Duplicate entry shall be ignored.

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
}