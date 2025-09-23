package pixel.academy.crud_app1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app1.dao.StudentDAO;

@SpringBootApplication
public class CrudApp1Application {

    public static void main(String[] args) {
        SpringApplication.run(CrudApp1Application.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return  runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
    }
}
