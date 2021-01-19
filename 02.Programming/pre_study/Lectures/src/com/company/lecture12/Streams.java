package com.company.lecture12;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Streams {
    ArrayList<String> stringList = new ArrayList<>();

    Streams() {
        stringList.add("a1");
        stringList.add("a2");
        stringList.add("b1");
        stringList.add("b2");
        stringList.add("c1");
        stringList.add("c2");

        System.out.println("Skriv ut i en foreach-loop");
        for (String elem :
                stringList) {
            System.out.println(elem);
        }
        System.out.println("Skriv ut med en stream");
        stringList
                .stream()
                .filter(str -> str.startsWith("c"))
                .forEach(System.out::println);

        double[] xPoints = {2.2,4.4,6.6,8.8};
        double[] yPoints = {1.1,3.3,5.5,7.7};
        double scalar = 2;
        Mapper doublesToInts = (d) -> Arrays.stream(d).map(i -> i * scalar).mapToInt(i -> (int) Math.round(i)).toArray();
        int[] xInts = doublesToInts.map(xPoints);
        for (int anInt : xInts) {
            System.out.println(anInt);
        }

        int[] yInts = doublesToInts.map(xPoints);
        for (int anInt : yInts) {
            System.out.println(anInt);
        }
    }
    interface Mapper{
        int[] map(double[] doubles);
    }
}
