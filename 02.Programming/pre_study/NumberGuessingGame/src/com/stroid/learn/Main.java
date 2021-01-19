package com.stroid.learn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int randomNumber = 5;
        int maxNumber = 20;

        boolean gameActive = true;

        System.out.println("Guess a number between 1 and 20: ");

        while (gameActive ) {

            int playerGuess = getGuess();

            if (randomNumber == playerGuess) {

                gameActive = false;

                System.out.println("You guess was right!");

            } else if( randomNumber > playerGuess){

                System.out.println("Sorry, you guess was to low, try again!");

            }
            else if( randomNumber < playerGuess){

                System.out.println("Sorry, you guess was to high, try again!");

            }
        }
        System.out.println("Good bye");
    }

    static public int getGuess(){

        Scanner scanner = new Scanner(System.in);

        boolean validNumber;

       int playerGuess = 0;

        do {

            String playerGuessString = scanner.nextLine();

            validNumber = true;

            try {

                playerGuess = Integer.parseInt( playerGuessString );

            } catch (NumberFormatException e) {

                System.out.println("Your guess '" + playerGuessString + "' is not a valid number, try again!" );

                validNumber = false;

            }
        } while (!validNumber);

        return playerGuess;
    }
}
