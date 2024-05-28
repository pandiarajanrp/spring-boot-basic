package com.learn.springboot.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages= {
				"com.learn.springboot.learnspringboot",
				"util"
		}
)
public class LearnspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnspringbootApplication.class, args);
	}

}
