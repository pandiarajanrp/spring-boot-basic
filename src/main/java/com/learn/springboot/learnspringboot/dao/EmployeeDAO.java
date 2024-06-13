package com.learn.springboot.learnspringboot.dao;

import com.learn.springboot.learnspringboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    // void save(Employee employee);
    List<Employee> findAll();
//
//    Employee findById(Integer id);
//
//    Student update(Integer id, Student studentData);
//
//    void delete(Integer id);
}
