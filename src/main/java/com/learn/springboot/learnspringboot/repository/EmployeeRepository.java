package com.learn.springboot.learnspringboot.repository;

import com.learn.springboot.learnspringboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
