package com.learn.springboot.learnspringboot.rest;

import com.learn.springboot.learnspringboot.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class StudentController {
    @GetMapping()
    public List<Student> getCustomer() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Pandiarajan", "Rajagopal", "pandiarajan.rp@gmail.com"));
        students.add(new Student("John", "Smith", "john.smith@gmail.com"));
        students.add(new Student("Pablo", "Marty", "pablo.marty@gmail.com"));
        return students;
    }
}

