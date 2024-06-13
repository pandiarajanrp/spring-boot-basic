package com.learn.springboot.learnspringboot.dao;

import com.learn.springboot.learnspringboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee save(Employee employee);

    Employee findById(Integer id);

    void delete(Integer id);
}
