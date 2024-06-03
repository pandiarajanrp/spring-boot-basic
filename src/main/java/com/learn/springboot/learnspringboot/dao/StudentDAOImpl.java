package com.learn.springboot.learnspringboot.dao;

import com.learn.springboot.learnspringboot.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("From Student order by lastName", Student.class);
        return query.getResultList();
    };

    @Override
    public List<Student> findAllByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("From Student where lastName=:lastName", Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Student updateById(Integer id, String firstName) {
        Student student = findById(id);
        student.setFirstName(firstName);
        return entityManager.merge(student);
    };

    @Override
    @Transactional
    public int updateAll(String firstName) {
        return entityManager.createQuery("UPDATE Student SET firstName=`Test`").executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = findById(id);
        entityManager.remove(student);
    }
}
