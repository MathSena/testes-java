package business;

import br.com.mathsena.service.CourseService;

import java.util.ArrayList;
import java.util.List;

// System Under Test
public class CourseBusiness {

    private final CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student){
        var filteredCourses = new ArrayList<String>();
        var allCourse = service.retrieveCourse(student);

        for(String course : allCourse){
            if(course.contains("Spring")){
                filteredCourses.add(course);
            }

        }

        return filteredCourses;

    }
}
