package com.company.lecture13;

public class Lambda {
    public static void main(String[] args) {
        MyAdd addFunc = (a, b) -> a + b;

        int sum = addFunc.func(2,3);
        System.out.println(sum);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    @FunctionalInterface
    interface MyAdd{
        int func(int x, int y);
    }
}