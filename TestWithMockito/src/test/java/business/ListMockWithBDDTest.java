package business;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

class ListMockWithBDDTest {

        @Test
        @DisplayName("Size method should return 10 when called")
        void whenSizeIsCalled_ShouldReturn10() {
            List list = mock(List.class);
            given(list.size()).willReturn(10);

            assertThat(10, is(list.size()));
        }

        @Test
        @DisplayName("Size method should return multiple values in sequence when called multiple times")
        void whenSizeIsCalled_ShouldReturnMultipleValues() {
            List list = mock(List.class);
            given(list.size()).willReturn(10).willReturn(20);

            assertThat(10, is(list.size()));
            assertThat(20, is(list.size()));
            assertThat(20, is(list.size()));
        }

        @Test
        @DisplayName("Get method with index 0 should return 'Matheus'")
        void whenGetIsCalledWithIndex0_ShouldReturnMatheus() {
            List list = mock(List.class);
            given(list.get(0)).willReturn("Matheus");

            assertThat("Matheus", is(list.get(0)));
        }

        @Test
        @DisplayName("Get method with any index should return 'Matheus'")
        void whenGetIsCalledWithAnyIndex_ShouldReturnMatheus() {
            List list = mock(List.class);
            given(list.get(anyInt())).willReturn("Matheus");

            assertThat("Matheus", is(list.get(0)));
            assertThat("Matheus", is(list.get(5)));
            assertThat("Matheus", is(list.get(100)));
        }

        @Test
        @DisplayName("Get method with invalid index should throw IndexOutOfBoundsException")
        void whenGetIsCalledWithInvalidIndex_ShouldThrowException() {
            List list = mock(List.class);
            given(list.get(-1)).willThrow(new IndexOutOfBoundsException("Invalid index"));

            assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        }

}
