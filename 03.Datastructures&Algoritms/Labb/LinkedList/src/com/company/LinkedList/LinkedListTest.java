package com.company.LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    @DisplayName("Test add a element to list")
    void testAddElementToList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        assertEquals(1, linkedList.get(0));
    }

    @Test
    @DisplayName("Test add a element to list at Index")
    void testAddElementToListAtIndex() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(0, 4);
        assertEquals(4, linkedList.get(0));
    }

    @Test
    @DisplayName("Test add a element to list at index 0")
    void testAddElementToListAtIndex0() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0, 4);
        assertEquals(4, linkedList.get(0));
    }

    @Test
    @DisplayName("Test add a element to list out of bounds")
    void testAddElementToListAtIndexOutOfBounds() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(2, 4));
    }

    @Test
    @DisplayName("Test add a element to list out of bounds at index 0")
    void testAddElementToListAtIndexOutOfBoundsIndex0() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(2, 4));
    }

    @Test
    @DisplayName("Test if the correct size is returned")
    void testGetListSize() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertEquals(3, linkedList.size());
    }

    @Test
    @DisplayName("Test get element out of bonds")
    void testGetElementAtOutbounds() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }

    @Test
    @DisplayName("Test get element out of bonds")
    void testGetElementAtIndexOutOutbounds() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }

    @Test
    @DisplayName("Test get element at index")
    void testGetElementAtIndex() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        assertEquals(2, linkedList.get(1));
    }

    @Test
    @DisplayName("Test get element at index 0")
    void testGetElementAtIndex0() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        assertEquals(1, linkedList.get(0));
    }

    @Test
    @DisplayName("Test if the correct size is returned")
    void testGetListSizeOf0() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        assertEquals(0, linkedList.size());
    }

    @Test
    @DisplayName("Test if size decreases when remove is run")
    void testRemoveElementFromList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        assertEquals(4, linkedList.size());
        linkedList.remove(2);
        assertEquals(3, linkedList.size());
    }

    @Test
    @DisplayName("Test if the correct size is returned")
    void testRemoveCorrectElementFromList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertEquals(2, linkedList.get(1));
        linkedList.remove(1);
        assertEquals(3, linkedList.get(1));
    }

    @Test
    @DisplayName("Test if the element is removed at index 0")
    void testRemoveCorrectElementFromListAtIndex0() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.remove(0);
        assertEquals(0, linkedList.size());
    }

    @Test
    @DisplayName("Test labb prerequisites")
    void testEveryLabbPrerequisites() {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        assertEquals(3, l.size());
        l.add(0, 99);
        assertEquals(4, l.size());
        assertEquals(99, l.get(0));
        assertEquals(3, l.get(3));
        l.remove(3);
        assertEquals(3, l.size());
        assertFalse(l.empty());
    }

    @Test
    @DisplayName("Test if list contains the value")
    void testListContainsValueOf() {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        assertTrue(l.contains(2));
        assertFalse(l.contains(8));
    }

    @Test
    @DisplayName("Test if false is returned if the list is empty")
    void testContainsEmptyList() {
        LinkedList<Integer> l = new LinkedList<>();
        assertFalse(l.contains(1));
    }
}