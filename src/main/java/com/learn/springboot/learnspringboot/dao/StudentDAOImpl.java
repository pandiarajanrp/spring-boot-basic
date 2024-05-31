package com.learn.springboot.learnspringboot.dao;

import com.learn.springboot.learnspringboot.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
    //define the field for entity manager
    private EntityManager entityManager;

    //inject the entity manager by constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }
}
