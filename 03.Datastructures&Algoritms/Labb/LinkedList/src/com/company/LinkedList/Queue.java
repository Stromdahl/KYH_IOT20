package com.company.LinkedList;


public class Queue<E> {
    private final LinkedList<E> linkedList = new LinkedList<>();

    void enqueue(E value) {
        linkedList.add(value);
    }

    E dequeue() {
        E value = linkedList.get(0);
        linkedList.remove(0);
        return value;
    }

    E peek() {
        return linkedList.get(0);
    }

    int size() {
        return linkedList.size();
    }
}
