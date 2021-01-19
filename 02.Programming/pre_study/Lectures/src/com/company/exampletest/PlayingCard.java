package com.company.exampletest;

public class PlayingCard {
    private int value;
    private String color;

    public PlayingCard(String color, int value) throws IllegalArgumentException{
        if(value < 1 || value > 13){
            throw new IllegalArgumentException();
        }
        this.value = value;
        this.color = color;
    }

    public PlayingCard(){
        this("Hearts", 1);
    }

    public String toString() {
        return String.format("%d of %s", this.value, this.color);
    }

    public int getValue(){
        return value;
    }
    public int setValue(int value){
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }
}
