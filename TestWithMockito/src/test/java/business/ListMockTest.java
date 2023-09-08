package business;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListMockTest {

    @Test
    void whenSizeIsCalled_ShouldReturn10() {
        List list = mock(List.class);
        when(list.size()).thenReturn(10);

        assertEquals(10, list.size());
    }

    @Test
    void whenSizeIsCalled_ShouldReturnMultipleValues() {
        List list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);

        assertEquals(10, list.size());
        assertEquals(20, list.size());
        assertEquals(20, list.size());
    }

    @Test
    void whenGetIsCalledWithIndex0_ShouldReturnMatheus() {
        List list = mock(List.class);
        when(list.get(0)).thenReturn("Matheus");

        assertEquals("Matheus", list.get(0));
    }

    @Test
    void whenGetIsCalledWithAnyIndex_ShouldReturnMatheus() {
        List list = mock(List.class);
        when(list.get(anyInt())).thenReturn("Matheus");

        assertEquals("Matheus", list.get(0));
        assertEquals("Matheus", list.get(5));
        assertEquals("Matheus", list.get(100));
    }

    @Test
    void whenGetIsCalledWithInvalidIndex_ShouldThrowException() {
        List list = mock(List.class);
        when(list.get(-1)).thenThrow(new IndexOutOfBoundsException("Invalid index"));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }
}
