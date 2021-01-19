package com.company.lecture13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {

        System.out.println("Print out Array");
        List<Integer > array = Arrays.asList(1,3,2,6,5);
        array.forEach(System.out::println);

        List<Integer> newArray =
                array.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Print out sorted Array");
        newArray.forEach(System.out::println);

        List<Integer> evenNumberArray = array.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Print out only even numbers");
        evenNumberArray.forEach(System.out::println);

        int reduceSum = array.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.printf("Sum of array:%s\n", reduceSum);
    }
}
