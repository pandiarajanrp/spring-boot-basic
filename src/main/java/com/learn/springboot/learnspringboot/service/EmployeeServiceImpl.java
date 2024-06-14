package com.learn.springboot.learnspringboot.service;

import com.learn.springboot.learnspringboot.entity.Employee;
import com.learn.springboot.learnspringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Repository
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> result = this.employeeRepository.findById(id);

        Employee employee = null;
        if(result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Employee not found");
        }

        return employee;
    }

    @Override
    public void delete(Integer id) {
        Employee employee = findById(id);
        this.employeeRepository.delete(employee);
    }
}

// DAO
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//    private EmployeeDAO employeeDAO;
//
//    @Autowired
//    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return this.employeeDAO.findAll();
//    }
//
//    @Override
//    @Transactional
//    public Employee save(Employee employee) {
//        return this.employeeDAO.save(employee);
//    }
//
//    @Override
//    public Employee findById(Integer id) {
//        return this.employeeDAO.findById(id);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Integer id) {
//        this.employeeDAO.delete(id);
//    }
//}
