package io.awklabs.datastructures.graph;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {
  private T element;
  private List<Node<T>> children;
  private boolean visited;

  public Node(T element) {
    this.element = element;
    this.children = new LinkedList<>();
    this.visited = false;
  }

  public void addChild(Node<T> node) {
    this.children.add(node);
  }

  public List<Node<T>> children() {
    return children;
  }

  public boolean visited() {
    return visited;
  }

  public void visit() {
    visited = true;
  }

  public T element() {
    return element;
  }

  public void reset() {
    visited = false;
  }
}
