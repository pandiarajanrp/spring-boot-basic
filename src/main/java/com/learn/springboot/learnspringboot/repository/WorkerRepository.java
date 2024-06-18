package com.learn.springboot.learnspringboot.repository;

import com.learn.springboot.learnspringboot.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// By default it exposes the endpoint with workers path
// @RepositoryRestResource provides an option to change the path name
@RepositoryRestResource(path = "members")
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
