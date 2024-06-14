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

    @PostMapping()
    public Employee createEmployee(@RequestBody Employee employee) {
        System.out.println("Coming here");
        Employee emp = employeeService.save(employee);
        return emp;
    }

    @GetMapping()
    public List<Employee> getEmployee() {
        return this.employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employee.setId(id);
        Employee emp = employeeService.save(employee);
        return emp;
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
    }
}
