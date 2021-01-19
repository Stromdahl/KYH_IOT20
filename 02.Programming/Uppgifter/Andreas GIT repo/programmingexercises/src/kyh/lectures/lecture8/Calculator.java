package kyh.lectures.lecture8;

import java.util.Scanner;

public class Calculator {
    public int memory = 0;

    public Calculator() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {

        }
    }

    public int add(int a, int b) {
        return a+b;
    }

    public void saveToMemory(int a) {
        this.memory = a;
    }

    public int recallMemory() {
        return this.memory;
    }

    public int subtract(int a, int b) {
        return a-b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public static void main(String[] args) {
        int a, b;
        String method;
        Calculator calc = new Calculator();
        System.out.println("Welcome to the Calculator!");
        Scanner sc = new Scanner(System.in);

        //Lägg till Modulo (%), Division (/), Max(max)
        while (sc.hasNext()) {
            a = sc.nextInt();
            method = sc.next();
            b = sc.nextInt();
            if (method.equals("+")) {
                System.out.println("The answer is: " + calc.add(a, b));
            } else if (method.equals("-")) {
                System.out.println("The answer is: " + calc.subtract(a, b));
            } else if (method.equals("*")) {
                System.out.println("The answer is: " + calc.multiply(a, b));
            } else {
                calc.throwException();
            }
        }
    }

    public int max(int a, int b) {
        if(a > b) {
            return a;
        }
        return b;
    }

    public void throwException() {
        throw new IllegalArgumentException("The method of calculation is not supported yet");
    }
}