package io.awklabs.datastructures.linkedlist;

import io.awklabs.datastructures.DataStructuresTestBase;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class LinkedListTest extends DataStructuresTestBase {

    private LinkedList<Integer> linkedList;

    @Override
    @Before
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
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Linked List Full");
        Stream.of(data).forEach(linkedList::insertAtLast);
        linkedList.insertAtLast(30);
    }

    @Test
    public void testIteratorAfterIteratorEnded() {
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("Reached end of Linked List");
        Stream.of(data).forEach(linkedList::insertAtLast);
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

}