package com.learn.springboot.learnspringboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class FirstRestController {
    @Value("${aws.sdk.version}")
    private String version;
    @GetMapping("/")
    public String printHelloWorld() {
        return this.version;
    }
}
