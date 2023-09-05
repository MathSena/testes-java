package br.com.mathsena.math;

import br.com.mathsena.SimpleMath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.logging.Logger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing SimpleMath class ")
public class AdvancedSimpleMathTest {

    SimpleMath math;
    final double DELTA = 2D;
    private static final Logger LOGGER = Logger.getLogger(AdvancedSimpleMathTest.class.getName());

    @BeforeEach
    void setUp() {
        math = new SimpleMath();
        LOGGER.info("Setting up the test...");
    }

    @ParameterizedTest
    @DisplayName("Test Division: 15 / 3 = 5")
    @MethodSource("testDivisionInputParameters")
    void testDivision( double first, double second, double expected ) {
        LOGGER.info("Running testDivision...");


        Double actual = math.division(first, second);

        assertEquals(expected, actual, DELTA, ()-> first + " / " + second +
                " should be " + expected);
        assertNotEquals(9.2, actual, DELTA);
        assertNotNull(actual);
    }

    public static Stream<Arguments> testDivisionInputParameters(){
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(71D, 14D, 5.0D),
                Arguments.of(18.3D, 3.1D, 5.9D)
        );



    }



}
