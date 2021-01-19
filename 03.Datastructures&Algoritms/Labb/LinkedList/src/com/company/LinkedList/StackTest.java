package com.company.LinkedList;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StackTest {
    @Test
    @DisplayName("Test if push adds value")
    void testPushAddsValue() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        assertEquals(1, stack.pop());
    }

    @Test
    @DisplayName("Test if peak return correct value")
    void testPeekReturnsCorrectValue() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    @Test
    @DisplayName("Test if size return correct size")
    void testSizeReturnsCorrectSize() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }
}