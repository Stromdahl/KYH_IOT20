package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDie {

    @Test
    @DisplayName("Testing that true is returned when the two dice are equal")
    void isTrueWhenTwoDiceHasEqualValue() {
        Die die = new Die(6);
        Die die2 = new Die(6);
        assertTrue(die.equals(die2));
    }

    @Test
    @DisplayName("Testing that false is returned when the two dice are unequal")
    void isFalseWhenTwoDiceDoesNotHaveEqualValue() {
        Die die = new Die(1);
        Die die2 = new Die(6);
        assertFalse(die.equals(die2));
    }
}
