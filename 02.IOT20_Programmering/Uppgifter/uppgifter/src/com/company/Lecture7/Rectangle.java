package com.company.Lecture7;

public class Rectangle implements Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea(){
        return Math.toIntExact(Math.round(this.height * this.width));
    }

    public int getCircumference(){
        return Math.toIntExact(Math.round(2*this.height + 2*this.width));
    }
}
