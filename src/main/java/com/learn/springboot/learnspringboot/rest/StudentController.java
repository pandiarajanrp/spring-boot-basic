package com.learn.springboot.learnspringboot.rest;

import com.learn.springboot.learnspringboot.entity.Student;
import com.learn.springboot.learnspringboot.error.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students;

    @PostConstruct
    private List<Student> loadStudents() {
        students = new ArrayList<>();
        students.add(new Student("Pandiarajan", "Rajagopal", "pandiarajan.rp@gmail.com"));
        students.add(new Student("John", "Smith", "john.smith@gmail.com"));
        students.add(new Student("Pablo", "Marty", "pablo.marty@gmail.com"));
        return students;
    }
    @GetMapping()
    public List<Student> getCustomer() {
        return students;
    }
    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // System.out.println("Student ID " + studentId);
        if(studentId < 0 || studentId > students.size()) {
            throw new StudentNotFoundException("Student not found with ID " + studentId);
        }
        return students.get(studentId);
    }
}

