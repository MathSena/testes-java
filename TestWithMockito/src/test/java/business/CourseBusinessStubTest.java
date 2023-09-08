package business;

import br.com.mathsena.service.CourseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.stub.CourseServiceStub;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CourseBusinessStubTest {

    @Test
    @DisplayName("Should return courses related to 'History' for the student 'Matheus'")
    void shouldReturnCoursesRelatedToHistoryForMatheus() {

        // Given
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        // When
        List<String> filteredCourses = business.retrieveCoursesRelatedToSpring("Matheus");

        // Then
        assertFalse(filteredCourses.isEmpty(), "The course list should not be empty");
        assertTrue(filteredCourses.stream().anyMatch(course -> course.contains("Spring")), "At least one course should contain 'History'");
    }

    @Test
    @DisplayName("Should not return courses with 'History' for the student 'Matheus'")
    void shouldNotReturnCoursesWithHistoryForMatheus() {

        // Given
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        // When
        List<String> filteredCourses = business.retrieveCoursesRelatedToSpring("Matheus");

        // Then
        assertFalse(filteredCourses.stream().anyMatch(course -> course.contains("History")), "No course should contain 'History'");
    }

}
