package io.awklabs.datastructures.tree.rbtree;

import io.awklabs.datastructures.DataStructuresTestBase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RedBlackTreeTest extends DataStructuresTestBase {

    RedBlackTree<Integer> redBlackTree;

    @Before
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
        result.forEach(System.out::println);
    }

}