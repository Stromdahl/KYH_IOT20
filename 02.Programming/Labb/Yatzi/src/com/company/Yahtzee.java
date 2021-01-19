package com.company;

public class Yahtzee {
    private Die[] dice = new Die[5];

    Yahtzee() {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
    }

    public void setDiceValues(int[] diceValues) {
        for (int i = 0; i < this.dice.length; i++) {
            dice[i].setValue(diceValues[i]);
        }
    }

    public int getDieValue(int index) {
        return dice[index].getValue();
    }

    public void printDice() {
        for (int i = 0; i < dice.length; i++) {
            System.out.println(i + ": Dice shows " + dice[i].getValue());
        }
    }

    public boolean checkForYahtzee() {
        for (int i = 1; i < dice.length; i++) {
            if (!dice[0].equals(dice[i])) return false;
        }
        return true;
    }
}