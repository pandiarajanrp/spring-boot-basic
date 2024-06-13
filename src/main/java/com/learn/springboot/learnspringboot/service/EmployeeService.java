package com.learn.springboot.learnspringboot.service;

import com.learn.springboot.learnspringboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee save(Employee employee);

    Employee findById();

    void delete(Integer id);
}
