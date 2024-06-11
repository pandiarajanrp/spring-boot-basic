package com.learn.springboot.learnspringboot;

import com.learn.springboot.learnspringboot.dao.StudentDAO;
import com.learn.springboot.learnspringboot.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(
		scanBasePackages= {
				"com.learn.springboot.learnspringboot",
				"util"
		}
)
public class LearnspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnspringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// getStudentById(studentDAO);
			// getAllStudents(studentDAO);
			// getAllByLastName(studentDAO);
			// updateById(studentDAO);
			// updateAll(studentDAO);
			// deleteStudentById(studentDAO);
			// deleteAll(studentDAO);
			// getAllStudents(studentDAO);
		};
	}

	private void updateAll(StudentDAO studentDAO) {
		studentDAO.updateAll("Mexico");
	}

	private void updateById(StudentDAO studentDAO) {
		studentDAO.updateById(1, "Sina");
	}

	private void getAllByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAllByLastName("Smith");
		System.out.println(studentList);
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		System.out.println(studentList);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object");
		//create new student object
		Student student = new Student("Pandiarajan", "Rajagopal", "pandiarajan.rp@gmail.com");
		System.out.println("Storing student data");
		//save new student object
		studentDAO.save(student);

		Student student2 = new Student("John", "Smith", "john.smith@gmail.com");
		System.out.println("Storing student data");
		//save new student object
		studentDAO.save(student2);

		//display newly generated student id
		System.out.println("Student Generated ::: " + student.getId());

		//get student details by id
		Student getById = studentDAO.findById(1);
		System.out.println(getById);
	}

	private void getStudentById(StudentDAO studentDAO) {
		Student getById = studentDAO.findById(1);
		System.out.println(getById);
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		studentDAO.delete(1);
	}

	private void deleteAll(StudentDAO studentDAO) {
		Integer count = studentDAO.deleteAll();
		System.out.println("Deleted count " + count);
	}
}
