package com.learn.springboot.learnspringboot.rest;

import com.learn.springboot.learnspringboot.entity.Student;
import com.learn.springboot.learnspringboot.error.StudentErrorResponse;
import com.learn.springboot.learnspringboot.error.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exec) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exec.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exec) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Bad Request");
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

