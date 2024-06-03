package com.learn.springboot.learnspringboot.dao;

import com.learn.springboot.learnspringboot.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllByLastName(String lastName);

    Student updateById(Integer id, String firstName);

    int updateAll(String firstName);

    void delete(Integer id);
}
