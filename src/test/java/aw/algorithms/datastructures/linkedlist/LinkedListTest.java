package aw.algorithms.datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aw.algorithms.datastructures.DataStructuresTestBase;

public class LinkedListTest extends DataStructuresTestBase {

  private LinkedList<Integer> linkedList;

  @Override
  @BeforeEach
  public void before() {
    super.before();
    linkedList = new LinkedList<>(10);
  }

  @Test
  public void testDefaultSize() {
    LinkedList<Object> linkedList = new LinkedList<>();
    assertEquals(256, linkedList.capacity());
  }

  @Test
  public void testMaxSize() {
    LinkedList<Object> linkedList = new LinkedList<>(257);
    assertEquals(256, linkedList.capacity());
  }

  @Test
  public void testInsertAtLast() {
    Stream.of(data).forEach(linkedList::insertAtLast);
    List<Integer> expected = Arrays.asList(Arrays.copyOf(data, data.length));
    List<Integer> actual = linkedList.asList();
    assertEquals(10, linkedList.size());
    assertEquals(expected, actual);
  }

  @Test
  public void testInsertAtFirst() {
    Stream.of(data).forEach(linkedList::insertAtLast);
    List<Integer> expected = Arrays.asList(Arrays.copyOf(data, data.length));
    List<Integer> actual = linkedList.asList();
    assertEquals(10, linkedList.size());
    assertEquals(expected, actual);
  }

  @Test
  public void testDeleteAtLast() {
    Stream.of(data).forEach(linkedList::insertAtLast);
    List<Integer> expected = Arrays.asList(5, 6, 7, 1, 2, 8, 3, 10, 4);
    linkedList.deleteFromLast();
    List<Integer> actual = linkedList.asList();
    assertEquals(9, linkedList.size());
    assertEquals(expected, actual);
  }

  @Test
  public void testDeleteFromFirst() {
    Stream.of(data).forEach(linkedList::insertAtLast);
    List<Integer> expected = Arrays.asList(6, 7, 1, 2, 8, 3, 10, 4, 9);
    linkedList.deleteFromFirst();
    List<Integer> actual = linkedList.asList();
    assertEquals(9, linkedList.size());
    assertEquals(expected, actual);
  }

  @Test
  public void testInsertWhenLinkedListFull() {
    Stream.of(data).forEach(linkedList::insertAtLast);
    assertThrows(RuntimeException.class, () -> linkedList.insertAtLast(30), "Linked List Full");
  }

  @Test
  public void testIteratorAfterIteratorEnded() {
    Stream.of(data).forEach(linkedList::insertAtLast);
    Iterator<Integer> iterator = linkedList.iterator();
    while (iterator.hasNext()) {
      iterator.next();
    }
    assertThrows(NoSuchElementException.class, () -> iterator.next(), "Reached end of Linked List");
  }
}
