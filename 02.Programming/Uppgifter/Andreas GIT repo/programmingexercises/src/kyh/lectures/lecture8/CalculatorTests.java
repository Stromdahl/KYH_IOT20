package kyh.lectures.lecture8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Calculator")
public class CalculatorTests {
    private final Calculator calculator = new Calculator();

    @BeforeEach
    void prepare() {
        calculator.saveToMemory(0);
    }

    @AfterEach
    void after() {
        calculator.saveToMemory(0);
    }

    @Test
    @DisplayName("Testing that addition works")
    void addition() {
        assertEquals(3, calculator.add(1, 2));
        assertEquals(5, calculator.add(-5, 10));
        assertEquals(1400000, calculator.add(700000, 700000));
    }

    @Test
    void testMemory() {
        assertEquals(0, calculator.recallMemory());
    }

    @Test
    @DisplayName("Testing that subtraction works")
    void subtraction() {
        assertEquals(-1, calculator.subtract(1, 2));
        assertEquals(-15, calculator.subtract(-5, 10));
        assertEquals(0, calculator.subtract(700000, 700000));
        assertNotEquals(-15, calculator.subtract(-15,-1));
    }

    @Test
    @DisplayName("Testing that multiplication works")
    void multiplication() {
        assertEquals(2, calculator.multiply(1, 2));
        assertEquals(-35, calculator.multiply(-7, 5));
        assertEquals(20000, calculator.multiply(200, 100));
    }

    @Test
    @DisplayName("Testing that max works")
    void max() {
        assertEquals(2, calculator.max(1, 2));
        assertEquals(0, calculator.max(0, -2));
        assertEquals(-2, calculator.max(-2, -2));
        assertEquals(100001, calculator.max(100000, 100001));
    }

    @Test
    @DisplayName("Testing that exception is thrown")
    void throwException() {
        Calculator calc = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calc.throwException());
    }
}