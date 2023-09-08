package mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class HamcrestMatchersTest {

    @Test
    @DisplayName("Test various Hamcrest matchers on lists, strings, and arrays")
    void testHamcrestMatchers() {
        // Given
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        // When e Then
        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(100, 101));
        assertThat(scores, everyItem(greaterThan(98)));
        assertThat(scores, everyItem(lessThan(106)));

        // Checking Strings
        assertThat("", is(emptyString()));
        assertThat("", is(emptyOrNullString()));

        // Arrays
        Integer[] myArray = {1, 2, 3};
        assertThat(myArray, arrayWithSize(3));
        assertThat(myArray, arrayContaining(1, 2, 3));
        assertThat(myArray, arrayContainingInAnyOrder(3, 2, 1));
    }
}
