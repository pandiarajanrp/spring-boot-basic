package com.learn.springboot.learnspringboot.repository;

import com.learn.springboot.learnspringboot.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
