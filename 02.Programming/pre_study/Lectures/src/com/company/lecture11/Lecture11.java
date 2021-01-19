package com.company.lecture11;

import java.util.ArrayList;
import java.util.List;

public class Lecture11 {
    
    public static void main(String[] args) {
        //--------Sort-------
        List<Long> numbers = new ArrayList();
        for(int i = 0; i<10; i++){
            numbers.add((long) (Math.random()*10));
            System.out.print(numbers.get(i));
        }
        System.out.println();

        Sorter.selectionSort(numbers);

        for (Long i : numbers) {
            System.out.print(i);
        }

        //-------Generics--------

        /*
        Box box = new Box(5);
        System.out.println(box.getContent());
        box.setContent(7);
        System.out.println(box.getContent());

         */
        
        //--------Swap-------

        /* List<String> colors = new ArrayList();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Purple");

        System.out.println();
        swap(colors, 2, 4);

        for (String i : colors) {
            System.out.println(i);
        }

         */
    }
}