package com.company;

import com.company.LinkedList.LinkedList;
import com.company.LinkedList.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l.size());
        l.add(0, 99);
        System.out.println(l.size());
        System.out.println(l.get(0));
        System.out.println(l.get(3));
        l.remove(3);
        System.out.println(l.size());
        System.out.println(l.empty());
    }
}
