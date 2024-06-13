package com.learn.springboot.learnspringboot.rest;

import com.learn.springboot.learnspringboot.entity.Employee;
import com.learn.springboot.learnspringboot.service.EmployeeService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getEmployee() {
        return this.employeeService.findAll();
    }

    @PostMapping()
    public Employee createEmployee() {
        return null;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(Integer id) {
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(Integer id) {

    }
}
