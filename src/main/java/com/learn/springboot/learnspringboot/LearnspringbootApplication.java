package com.learn.springboot.learnspringboot;

import com.learn.springboot.learnspringboot.dao.StudentDAO;
import com.learn.springboot.learnspringboot.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object");
		//create new student object
		Student student = new Student("Pandiarajan", "Rajagopal", "pandiarajan.rp@gmail.com");
		System.out.println("Storing student data");
		//save new student object
		studentDAO.save(student);
		//display newly generated student id
		System.out.println("Student Generated ::: " + student.getId());

		//get student details by id
		Student getById = studentDAO.findById(1);
		System.out.println(getById);
	}

}
