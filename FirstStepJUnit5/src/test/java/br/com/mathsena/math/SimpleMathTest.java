package br.com.mathsena.math;

import br.com.mathsena.SimpleMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleMathTest {

    @Test
    void testSum(){
        SimpleMath math = new SimpleMath();
        double first = 6.2D;
        double second = 2D;

        Double actual = math.sum(first, second);
        double expected = 8.2D;

        assertEquals(expected, actual, ()-> first + " + " + second +
                " did not produce " + expected +
                "!");
        assertNotEquals(9.2, actual);
        assertNotNull(actual);

    }

    @Test
    void testSubtraction(){
        SimpleMath math = new SimpleMath();
        double first = 6.2D;
        double second = 2D;

        Double actual = math.subtraction(first, second);
        double expected = 4.2D;

        assertEquals(expected, actual, ()-> first + " + " + second +
                " did not produce " + expected +
                "!");
        assertNotEquals(9.2, actual);
        assertNotNull(actual);

    }

    @Test
    void testMultiplication(){
        SimpleMath math = new SimpleMath();
        double first = 6.2D;
        double second = 2D;

        Double actual = math.multiplication(first, second);
        double expected = 12.4D;

        assertEquals(expected, actual, ()-> first + " + " + second +
                " did not produce " + expected +
                "!");
        assertNotEquals(9.2, actual);
        assertNotNull(actual);

    }

    @Test
    void testDivision(){
        SimpleMath math = new SimpleMath();
        double first = 15D;
        double second = 3D;

        Double actual = math.division(first, second);
        double expected = 5D;

        assertEquals(expected, actual, ()-> first + " + " + second +
                " did not produce " + expected +
                "!");
        assertNotEquals(9.2, actual);
        assertNotNull(actual);

    }

    @Test
    void testMean(){
        SimpleMath math = new SimpleMath();
        double first = 15D;
        double second = 3D;

        Double actual = math.mean(first, second);
        double expected = 9D;

        assertEquals(expected, actual, ()-> first + " + " + second +
                " did not produce " + expected +
                "!");
        assertNotEquals(9.2, actual);
        assertNotNull(actual);

    }

    @Test
    void testSquare(){
        SimpleMath math = new SimpleMath();
        double number = 16D;


        Double actual = math.squareRoot(number);
        double expected = 4D;

        assertEquals(expected, actual, ()-> number +
                " did not produce " + expected +
                "!");
        assertNotEquals(9.2, actual);
        assertNotNull(actual);

    }



}
