package pixel.academy.crud_app1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pixel.academy.crud_app1.dao.StudentDAO;
import pixel.academy.crud_app1.dao.StudentDAOImplementation;
import pixel.academy.crud_app1.entity.Student;

import java.util.List;

@SpringBootApplication
public class CrudApp1Application {

    public static void main(String[] args) {
        SpringApplication.run(CrudApp1Application.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return  runner -> {
          //  createStudent(studentDAO);
            //createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
           // queryForStudents(studentDAO);
           // queryForStudentsByLastName(studentDAO);
           // updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            deleteAllStudents(studentDAO);

        };
    }


    private void readStudent(StudentDAO studentDAO) {
        //creaza un obiect de tip Student
             System.out.println("Creating new student object ...");
             Student newStudent = new Student("Mircea", "Popescu", "mircea@pixel.academy");
             //salveaza studentul in baza de date
             System.out.println("Saving the student...");
             studentDAO.save(newStudent);

             //afiseaza id-ul studentului salvat
             int theId = newStudent.getId();
             System.out.println("Saved student. Generated id: " + theId);

             //recupereaza studentul pe baza ID-ului (PK)
             System.out.println("Retrieving student with id: " + theId);
             Student myStudent = studentDAO.findById(theId);

             //afiseaza detaliile studentului
             System.out.println("Found the student: " + myStudent);
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
        Student newStudent2 = new Student("Iulian", "Vataman" , "iulian@pixelacademy.md");
        Student newStudent3 = new Student("Maria" , "Mirabele", "maria@pixelacademy.md");

        //save objects in database
        System.out.println("Saving the students ...");
        studentDAO.save(newStudent1);
        studentDAO.save(newStudent2);
        studentDAO.save(newStudent3);
    }
    private void queryForStudents(StudentDAO studentDAO) {
        //get the list of students
        List<Student> theStudents = studentDAO.findAll();

        //display the list of students
        for (Student newStudent : theStudents) {
            System.out.println(newStudent);
        }
    }
        private void queryForStudentsByLastName(StudentDAO studentDAO) {

            //returneaza lista de studenti
            List<Student> theStudent = studentDAO.findByLastName("Popescu");

            //afiseaza lista de studenti
            for (Student newStudent : theStudent) {
                System.out.println(newStudent);
            }
        }
    private void updateStudent(StudentDAO studentDAO) {
        //find the student in the database using the ID (PK)
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student newStudent = studentDAO.findById(studentId);

        //modify firstName of the student "Ion"
        System.out.println("Updating student ...");
        newStudent.setFirstName("Ion");

        //save modified data in bd
        studentDAO.update(newStudent);

        //display details of the updated student
        System.out.println("Updated student: " + newStudent);
    }
    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deliting student id: " + studentId);
        studentDAO.delete(studentId);
    }
    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students.");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }
}

