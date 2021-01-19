package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class YahtzeeTest {

    @Test
    @DisplayName("Testing that checkForYahtzee returns true when all Dice are the same")
    void isYahtzeeWhenAllDiceMatches() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.setDiceValues(new int[]{6, 6, 6, 6, 6});
        assertTrue(yahtzee.checkForYahtzee());
    }

    @Test
    @DisplayName("Testing that checkForYahtzee returns false when all Dice are not the same")
    void isNotYahtzeeWhenOneDieIsNotMatchingTheOther() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.setDiceValues(new int[]{1, 2, 3, 4, 5});
        assertFalse(yahtzee.checkForYahtzee());
    }

    @Test
    @DisplayName("Testing that getDieValue returns correct value when the dice is set to some specific value")
    void testGetDieValue() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.setDiceValues(new int[]{1, 2, 3, 4, 5});
        assertEquals(1, yahtzee.getDieValue(0));
        assertEquals(2, yahtzee.getDieValue(1));
        assertEquals(3, yahtzee.getDieValue(2));
        assertEquals(4, yahtzee.getDieValue(3));
        assertEquals(5, yahtzee.getDieValue(4));
    }

    @Test
    @DisplayName("Testing that printDice prints the correct output to System.out")
    void testPrintDice() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.setDiceValues(new int[]{5, 4, 3, 2, 1});
        yahtzee.printDice();
        String actualOutput = outputStreamCaptor.toString();
        actualOutput = actualOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r", "\n");
        String expectedOutput = "0: Dice shows 5\n" +
                "1: Dice shows 4\n" +
                "2: Dice shows 3\n" +
                "3: Dice shows 2\n" +
                "4: Dice shows 1\n";
        assertEquals(expectedOutput, actualOutput);
    }
}