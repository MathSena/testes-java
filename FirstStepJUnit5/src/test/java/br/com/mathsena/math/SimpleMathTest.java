package br.com.mathsena.math;

import br.com.mathsena.SimpleMath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing SimpleMath class ")
public class SimpleMathTest {

    SimpleMath math;
    final double DELTA = 0.0001;
    private static final Logger LOGGER = Logger.getLogger(SimpleMathTest.class.getName());

    @BeforeEach
    void setUp() {
        math = new SimpleMath();
        LOGGER.info("Setting up the test...");
    }

    @Test
    @DisplayName("Test Sum: 6.2 + 2 = 8.2")
    void testSum() {
        LOGGER.info("Running testSum...");
        double first = 6.2D;
        double second = 2D;

        Double actual = math.sum(first, second);
        double expected = 8.2D;

        assertEquals(expected, actual, DELTA, ()-> first + " + " + second +
                " should be " + expected);
        assertNotEquals(9.2, actual, DELTA);
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test Subtraction: 6.2 - 2 = 4.2")
    void testSubtraction() {
        LOGGER.info("Running Subtraction...");
        double first = 6.2D;
        double second = 2D;

        Double actual = math.subtraction(first, second);
        double expected = 4.2D;

        assertEquals(expected, actual, DELTA, ()-> first + " - " + second +
                " should be " + expected);
        assertNotEquals(9.2, actual, DELTA);
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test Multiplication: 6.2 * 2 = 12.4")
    void testMultiplication() {
        LOGGER.info("Running Multiplication...");
        double first = 6.2D;
        double second = 2D;

        Double actual = math.multiplication(first, second);
        double expected = 12.4D;

        assertEquals(expected, actual, DELTA, ()-> first + " * " + second +
                " should be " + expected);
        assertNotEquals(9.2, actual, DELTA);
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test Division: 15 / 3 = 5")
    void testDivision() {
        LOGGER.info("Running testDivision...");
        double first = 15D;
        double second = 3D;

        Double actual = math.division(first, second);
        double expected = 5D;

        assertEquals(expected, actual, DELTA, ()-> first + " / " + second +
                " should be " + expected);
        assertNotEquals(9.2, actual, DELTA);
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test Mean: (15 + 3) / 2 = 9")
    void testMean() {
        LOGGER.info("Running testMean...");
        double first = 15D;
        double second = 3D;

        Double actual = math.mean(first, second);
        double expected = 9D;

        assertEquals(expected, actual, DELTA, ()-> "Mean of " + first + " and " + second +
                " should be " + expected);
        assertNotEquals(9.2, actual, DELTA);
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test Square Root of 16 = 4")
    void testSquare() {
        LOGGER.info("Running testSquare...");
        double number = 16D;

        Double actual = math.squareRoot(number);
        double expected = 4D;

        assertEquals(expected, actual, DELTA, ()-> "Square root of " + number +
                " should be " + expected);
        assertNotEquals(9.2, actual, DELTA);
        assertNotNull(actual);
    }



}
