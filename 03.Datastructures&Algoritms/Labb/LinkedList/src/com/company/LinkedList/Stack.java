package com.company.LinkedList;

public class Stack<E> {
    private final LinkedList<E> linkedList = new LinkedList<>();

    void push(E value) {
        linkedList.add(0, value);
    }

    E pop() {
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