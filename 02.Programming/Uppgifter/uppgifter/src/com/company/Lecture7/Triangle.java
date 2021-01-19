package com.company.Lecture7;

public class Triangle implements Shape{
    private double a, b, c;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int getArea() {
        double p = (a + b + c) / 2;
        return Math.toIntExact(Math.round(Math.sqrt(p * (p - a) * (p - b) * (p - c))));
    }

    @Override
    public int getCircumference() {
        return Math.toIntExact(Math.round(this.a + this.b + this.c));
    }
}
