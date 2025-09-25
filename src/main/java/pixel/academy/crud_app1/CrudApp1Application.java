package pixel.academy.crud_app1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
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
    private void createMultipleStudents(StudentDAO studentDAO) {

        //cream mai multi studenti
        System.out.println("Creating 3 student objects ...");
        Student newStudent1 = new Student("Andrei", "Munteanu", "andrei@pixelacademy.md");
        Student newStudent2 = new Student("Iulian", "Vataman", "iulian@pixelacademy.md");
        Student newStudent3 = new Student("Maria", "Mirabele", "maria@pixelacademy.md");

        //save objects in database
        System.out.println("Saving the students ...");
        studentDAO.save(newStudent1);
        studentDAO.save(newStudent2);
        studentDAO.save(newStudent3);
    }
}

