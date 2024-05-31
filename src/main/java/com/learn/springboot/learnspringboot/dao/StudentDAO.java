package com.learn.springboot.learnspringboot.dao;

import com.learn.springboot.learnspringboot.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
}
