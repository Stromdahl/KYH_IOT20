package kyh.lectures.lecture10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static int variable = 5;

    public Main() throws IllegalArgumentException {
            int result = this.add(-42,6);
            System.out.println(result);



        //System.out.println();
        // String x = 5 + "Hello"; // "5Hello"
        //printName("Besim");
        /*double[] testVariable = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};

        Person[] people = new Person[2];
        people[0] = new Person(100);
        people[1] = new Person(300);

        Person[] people2 = {new Person(100), new Person(300)};*/
                /*new double[8];
        for(int i=0;i<testVariable.length; i++) {
            testVariable[i] = 1.0;
        }*/
        //printAllElements(testVariable);
    }

    void printName(String name) {
        System.out.println(name);
    }

    int add(int a, int b) {
        if(a < 0 || b < 0) {
            throw new IllegalArgumentException("Error");
        }
        return a+b;
    }

    double add(int a, double b) {
        return a+b;
    }

    void printAllElements(double[] array) {
        for(int i=0; i<array.length;i++) {
            double element = array[i];
            System.out.println(element*i);
        }

        for(double element: array) {
            System.out.println(element);
        }

    }

    public static void main(String[] args) {
            new Main();




        /*Scanner sc = null;
        File f = new File("testData/Ost.txt");
        try {
            sc = new Scanner(new File("testData/Ost.txt"));
        } catch(Exception e) {

        } finally {
            sc.close();
        }*/



        /*for(String arg: args) {
            System.out.println(arg);
        }*/
        /*Main m1 = new Main();
        Main m2 = new Main();
        System.out.println(m1.equals(m2));*/

        Person p1 = new Person(2500);
        Person p2 = new Person(2500);
        //p1.eat(new Broccoli());
        //p1.eat(new Pizza());
        p1.eat(new IceCream());
        System.out.println(p1.isFull());
        p1.printEatenCaloriesToday();

        Food b = new Broccoli();
        p2.eat(b);
        p2.eat(b);
        p2.eat(b);
        p2.eat(b);
        p2.eat(b);
        p2.eat(b);
        System.out.println(p2.isFull());
        System.out.println("Equals: " + p1.equals(p2));
        p2.printEatenCaloriesToday();
        p1.printEatenCaloriesToday();

        System.out.println("InstanceOf: " + (p1 instanceof Object));
    }
}
