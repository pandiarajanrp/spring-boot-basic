package com.learn.springboot.learnspringboot.dao;

import com.learn.springboot.learnspringboot.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllByLastName(String lastName);
}
