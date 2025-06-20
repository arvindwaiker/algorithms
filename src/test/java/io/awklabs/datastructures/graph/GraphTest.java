package io.awklabs.datastructures.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.awklabs.datastructures.DataStructuresTestBase;

public class GraphTest extends DataStructuresTestBase {

  Graph<Integer> graph = new Graph<>();

  @Override
  @BeforeEach
  public void before() {
    super.before();
    Node<Integer> zero = new Node<>(0);
    Node<Integer> one = new Node<>(1);
    Node<Integer> two = new Node<>(2);
    Node<Integer> three = new Node<>(3);
    Node<Integer> four = new Node<>(4);
    Node<Integer> five = new Node<>(5);
    zero.addChild(one);
    zero.addChild(four);
    zero.addChild(five);
    one.addChild(three);
    one.addChild(four);
    two.addChild(one);
    three.addChild(two);
    three.addChild(four);
    five.addChild(four);
    List<Node<Integer>> nodes = Arrays.asList(zero, one, two, three, four, five);
    graph.nodes.addAll(nodes);
  }

  @Test
  public void testBFS() {
    List<Integer> result = new ArrayList<>();
    List<Integer> expected = Arrays.asList(0, 1, 4, 5, 3, 2);
    graph.bfs(graph.nodes.get(0), result);
    assertEquals(expected, result);
  }

  @Test
  public void testDFS() {
    List<Integer> result = new ArrayList<>();
    List<Integer> expected = Arrays.asList(0, 1, 3, 2, 4, 5);
    graph.dfs(graph.nodes.get(0), result);
    assertEquals(expected, result);
  }

  @Test
  public void testReset() {
    graph.dfs(graph.nodes.get(0), new ArrayList<>());
    List<Integer> result = new ArrayList<>();
    graph.dfs(graph.nodes.get(0), result);
    assertEquals(new ArrayList<>(), result);
    graph.reset();
    List<Integer> expected = Arrays.asList(0, 1, 3, 2, 4, 5);
    result = new ArrayList<>();
    graph.dfs(graph.nodes.get(0), result);
    assertEquals(expected, result);
  }
}
