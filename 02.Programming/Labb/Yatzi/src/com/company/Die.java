package com.company;

public class Die {
    private int value = 0;

    public Die() {
        roll();
    }

    public Die(int value) {
        this.value = value;
    }

    public void roll() {
        value = (int) (Math.random() * 6 + 1);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean equals(Die die) {
        return this.value == die.getValue();
    }
}