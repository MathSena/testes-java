package service.stub;

import br.com.mathsena.service.CourseService;

import java.util.Arrays;
import java.util.List;

public class CourseServiceStub implements CourseService {
    @Override
    public List<String> retrieveCourse(String student) {
        return Arrays.asList(
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

}
