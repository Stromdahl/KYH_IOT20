package com.company.LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {

    @Test
    @DisplayName("Test if Enqueue adds value")
    void testEnqueueAddsValue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(100);
        assertEquals(10, queue.peek());
    }

    @Test
    @DisplayName("Test if Dequeue removes and returns correct value")
    void testDequeueAndRemoveAndReturnsValue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(100);
        assertEquals(queue.dequeue(), 10);
        assertEquals(queue.peek(), 100);
    }

    @Test
    @DisplayName("Test if Peek returns correct value")
    void testPeekReturnsCorrectValue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(100);
        assertEquals(queue.peek(), 10);
    }

    @Test
    @DisplayName("Test if size return correct size")
    void testSizeReturnsCorrectSize() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(100);
        assertEquals(2, queue.size());
    }
}
