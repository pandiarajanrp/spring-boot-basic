package com.learn.springboot.learnspringboot.service;

import com.learn.springboot.learnspringboot.dao.EmployeeDAO;
import com.learn.springboot.learnspringboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public Employee findById() {
        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {

    }
}
