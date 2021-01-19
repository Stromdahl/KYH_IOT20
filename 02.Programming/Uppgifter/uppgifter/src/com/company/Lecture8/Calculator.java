package com.company.Lecture8;

import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) {
        int a, b;
        String method;
        Calculator calc = new Calculator();
        System.out.println("Welcome to the Calculator!");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            a = sc.nextInt();
            method = sc.next();
            b = sc.nextInt();
            if(method.equals("+")) {
                System.out.println("The answer is: " + calc.add(a,b));
            } else if(method.equals("-")){
                System.out.println("The answer is: " + calc.sub(a,b));
            } else if(method.equals("*")){
                System.out.println("The answer is: " + calc.multiply(a,b));
            } else if(method.equals("/")){
                System.out.println("The answer is: " + calc.division(a,b));
            } else if(method.equals("%")){
                System.out.println("The answer is: " + calc.modulo(a,b));
            } else if(method.equals("max")){
                System.out.println("The answer is: " + calc.max(a,b));
            } else {
                System.out.println("The method of calculation is not supported yet");
            }
        }
    }

    public int add(int a, int b) {
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        return a/b;
    }

    public int modulo(int a, int b) {
        return a%b;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}