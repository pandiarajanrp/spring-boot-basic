package com.learn.springboot.learnspringboot.dao;

import com.learn.springboot.learnspringboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    @Override
//    public void save(Employee employee) {
//        this.entityManager.persist(employee);
//    }

    @Override
    public List<Employee> findAll() {
        TypedQuery query = this.entityManager.createQuery("from Employee", EmployeeDAO.class);
        return query.getResultList();
    }
}
