package pixel.academy.crud_app1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app1.dao.StudentDAO;
import pixel.academy.crud_app1.entity.Student;

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

        //cream un nobiect Student

        System.out.println("Creating new student object...");
        Student newStudent = new Student("John", "Doe", "john@pixelacademy.md");

        //Salvam obiectul Student in baza de date folosind DAO

        System.out.println("Saving the student...");
        studentDAO.save(newStudent);

        //display ID of saved student
        System.out.println("Saved student.Generated id: " + newStudent.getId());
    }
}
