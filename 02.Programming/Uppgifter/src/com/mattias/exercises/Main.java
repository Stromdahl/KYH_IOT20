package com.mattias.exercises;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // https://www.w3resource.com/java-exercises/basic/

        exercise16();

    }

    static void exercise16(){

        System.out.println(" +\"\"\"\"\"+ ");
        System.out.println("[| o o |]");
        System.out.println(" |  ^  | ");
        System.out.println(" | '-' | ");
        System.out.println(" +-----+ ");

    }

    static void exercise15(){
        int a = 1;
        int b = 2;

        System.out.printf("Before swapping a = %d, b = %d\n", a, b);
        System.out.println("SWAP");

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.printf("After swapping a = %d, b = %d", a, b);

    }
    static void exercise14(){

        System.out.println("* * * * * * ==================================");
        System.out.println(" * * * * *  ==================================");
        System.out.println("* * * * * * ==================================");
        System.out.println(" * * * * *  ==================================");
        System.out.println("* * * * * * ==================================");
        System.out.println(" * * * * *  ==================================");
        System.out.println("* * * * * * ==================================");
        System.out.println(" * * * * *  ==================================");
        System.out.println("* * * * * * ==================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");

    }

    static void exercise13(){

        double width = 5.5;
        double height = 8.5;

        double area = width * height;

        double perimeter = 2 * ( width + height);

        System.out.printf("Area is %.1f * %.1f = %.1f\n", width, height, area);

        System.out.printf("Perimeter is 2(%.1f + %.1f) = %.1f", width, height, perimeter);
    }

    static void exercise12(){
        Scanner sc = new Scanner(System.in);

        System.out.print("First number: ");
        double a = sc.nextDouble();
        System.out.print("Second number: ");
        double b = sc.nextDouble();
        System.out.print("Second number: ");
        double c = sc.nextDouble();

        System.out.println("Average: " + ((a + b + c) / 3));
    }

    static void exercise11(){
        double radius = 7.5;

        double permimiter = radius*2*Math.PI;
        double area = Math.pow(radius, 2) * Math.PI;

        System.out.println("Perimiter: " + permimiter);
        System.out.println("Area: " + area);
    }

    static void exercise10(){
        System.out.println(4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11)));
    }

    static void exercise9(){
        System.out.println((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5));
    }

    static void exercise8(){
        System.out.println("   J    a   v     v  a");
        System.out.println("   J   a a   v   v  a a");
        System.out.println("J  J  aaaaa   V V  aaaaa");
        System.out.println(" JJ  a     a   V  a     a");
    }

    static void exercise7(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a number: ");
        int a = sc.nextInt();

        for(int b = 1; b <= 10; b++){
            int c = a * b;
            System.out.println( String.format("%d * %d = %d", a, b, c) );
        }
    }

    static void exercise6(){
        Scanner sc = new Scanner(System.in);

        System.out.print("First number: ");
        int a = sc.nextInt();
        System.out.print("Second number: ");
        int b = sc.nextInt();

        // 125 + 24 = 149
        int c = a + b;
        System.out.println( String.format("%d + %d = %d", a, b, c) );

        // 125 - 24 = 101
        c = a - b;
        System.out.println( String.format("%d - %d = %d", a, b, c) );

        // 125 x 24 = 3000
        c = a * b;
        System.out.println( String.format("%d * %d = %d", a, b, c) );

        // 125 / 24 = 5
        c = a / b;
        System.out.println( String.format("%d / %d = %d", a, b, c) );

        // 125 mod 24 = 5
        c = a % b;
        System.out.println( String.format("%d mod %d = %d", a, b, c) );

    }

    static void exercise5(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Input a number: ");
        int a = sc.nextInt();

        System.out.print("Enter first number: ");
        int nr1 = sc.nextInt();


        System.out.print("Enter second number: ");
        int nr2 = sc.nextInt();


        int res = nr1 * nr2;
        System.out.println(res);

    }

    static void exercise3(){
        /*
        Write a Java program to divide two numbers and print on the screen. Go to the editor
            Test Data :
            50/3
            Expected Output :
            16
         */

        System.out.println(50/3);

    }

    static void exercise1(){
        /*
        1. Write a Java program to print 'Hello' on screen and then print your name on a separate line.
            Expected Output :
            Hello
            Alexandra Abramov
         */

        String name = "Mattias Strömdahl";


        System.out.println("Hello");
        System.out.println(name);
    }

}