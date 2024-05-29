package com.learn.springboot.learnspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import util.Coach;
import util.SwimCoach;

@Configuration
public class SportsConfig {
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
