package aw.algorithms.datastructures.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph<T> {

  List<Node<T>> nodes;

  public Graph() {
    nodes = new LinkedList<>();
  }

  public void bfs(Node<T> node, List<T> result) {
    Queue<Node<T>> nodeQueue = new LinkedList<>();
    nodeQueue.add(node);

    while (!nodeQueue.isEmpty()) {

      Node<T> n = nodeQueue.remove();
      if (n.visited()) continue;
      n.children().stream().filter(c -> !c.visited()).forEach(nodeQueue::add);
      n.visit();

      result.add(n.element());
    }
  }

  public void dfs(Node<T> node, List<T> result) {
    if (node == null || node.visited()) {
      return;
    }
    node.visit();
    result.add(node.element());
    node.children()
        .forEach(
            n -> {
              if (!n.visited()) dfs(n, result);
            });
  }

  public void reset() {
    nodes.forEach(
        n -> {
          n.reset();
          n.children().stream().filter(Node::visited).forEach(Node::reset);
        });
  }
}
