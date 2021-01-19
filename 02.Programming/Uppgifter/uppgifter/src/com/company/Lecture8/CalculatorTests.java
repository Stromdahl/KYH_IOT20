package com.company.Lecture8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing Calculator")
public class CalculatorTests {
    private final Calculator calculator = new Calculator();


    @BeforeEach
    void prepare(){
        System.out.println("Testing...");
    }

    @Test
    @DisplayName("Testing that addition works")
    void testAddition() {
        assertEquals(3, calculator.add(1, 2));
        assertEquals(5, calculator.add(-5, 10));
        assertEquals(1400000000, calculator.add(700000000, 700000000));
    }

    @Test
    @DisplayName("Testing that subtraction works")
    void testSubtraction() {
        assertEquals(0, calculator.sub(5, 5));
        assertEquals(10, calculator.sub(5, -5));
    }

    @Test
    @DisplayName("Testing that multiply works")
    void testMultiplication(){
        assertEquals(100,calculator.multiply(10,10));
        assertEquals(50,calculator.multiply(2,25));
        assertEquals(25,calculator.multiply(5,5));
    }

    //div
    @Test
    @DisplayName("Testing that division works")
    void testDivision(){
        assertEquals(10, calculator.division(100,10));
        assertEquals(3, calculator.division(9,3));
        assertEquals(5, calculator.division(25,0));
    }

    @Test
    @DisplayName("Testing that Modulo works")
    void testModulo(){
        assertEquals(4, calculator.modulo(4,5));
        assertEquals(1, calculator.modulo(1,2));
        assertEquals(5, calculator.modulo(25,20));
    }

    @Test
    @DisplayName("Tesgin that max works")
    void testMax(){
        assertEquals(3, calculator.max(2,3));
        assertEquals(100, calculator.max(100,3));
        assertEquals(50, calculator.max(50,25));
    }


}
