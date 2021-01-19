package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Yahtzee!");
        Scanner sc = new Scanner(System.in);
        int currentTurn = 0;
        while (true) {
            Yahtzee yahtzee = new Yahtzee();
            System.out.println("Starting turn " + (currentTurn + 1) + " of 3, rolling dice.");
            yahtzee.printDice();
            if (yahtzee.checkForYahtzee()) {
                System.out.printf("You got YAHTZEE! in %d's\n", yahtzee.getDieValue(0));
                return;
            } else if (currentTurn < 2) {
                System.out.println("Want to throw again? (y for yes, anything else for no)");
                currentTurn++;
            } else {
                System.out.println("Game Over, Want to try again?");
                currentTurn = 0;
            }
            if (!sc.next().equals("y")) {
                return;
            }
        }
    }
}