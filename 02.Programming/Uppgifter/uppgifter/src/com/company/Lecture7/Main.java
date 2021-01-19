package com.company.Lecture7;

public class Main {

    public static void main(String[] args) {

        randomRectangle(1, 10);
        randomTriangle(1, 10);

    }

    public static void randomRectangle(int min, int max){
        double width = Math.random() * (max - min) + min;;
        double height = Math.random() * (max - min) + min;;

        Shape rectangle = new Rectangle(width, height);

        System.out.println("Rectangle Area: " + rectangle.getArea());
        System.out.println("Rectangle Circumference: " + rectangle.getCircumference());
    }

    public static void randomTriangle(int min, int max){
        double a = Math.random() * (max - min) + min;
        double b = Math.random() * (max - min) + min;;
        double c = Math.random() * (max - min) + min;;

        Shape triangle = new Triangle(a, b, c);

        System.out.println("Triangle Area: " + triangle.getArea());
        System.out.println("Triangle Circumference: " + triangle.getCircumference());
    }
}
