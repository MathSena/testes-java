package br.com.mathsena.math;

import br.com.mathsena.SimpleMath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    SimpleMath math;
    final double DELTA = 0.0001;
    private static final Logger LOGGER = Logger.getLogger(SimpleMathTest.class.getName());


    @RepeatedTest(3)
    @DisplayName("Test testDivisionByZero")
    void testDivisionByZero() throws Exception {
        LOGGER.info("Running testDivisionByZero...");
        double first = 15.2D;
        double second = 0.0D;

        assertThrows(ArithmeticException.class, ()->{
            math.division(first, second);
        });

    }
}
