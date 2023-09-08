package business;

import br.com.mathsena.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CourseBusinessMockTest {

    // Given
    CourseService mockService;
    CourseBusiness business;

    List<String> courses;

    @BeforeEach
    void setup() {
        // Given
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);
        courses = Arrays.asList(
                "Matemática Básica e Avançada",
                "Língua Portuguesa e Literatura Brasileira",
                "Redação",
                "Química",
                "Física",
                "Biologia",
                "História",
                "Geografia",
                "Língua Estrangeira (Inglês ou Espanhol)",
                "Spring Boot"
        );
    }

    @Test
    @DisplayName("Should return courses related to 'Spring Boot' for the student 'Matheus'")
    void shouldReturnCoursesRelatedToSpringBootForMatheusUsingMock() {

        // Given
        when(mockService.retrieveCourse("Matheus")).thenReturn(courses);

        // When
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Matheus");

        // Then
        assertFalse(filteredCourses.isEmpty(), "The course list should not be empty");
        assertTrue(filteredCourses.stream().anyMatch(course -> course.contains("Spring Boot")), "At least one course should contain 'Spring Boot'");
    }
}
