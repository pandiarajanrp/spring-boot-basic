package com.learn.springboot.learnspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder().username("john").password("{noop}john").roles("EMPLOYEE").build();
        UserDetails mary = User.builder().username("mary").password("{noop}mary").roles("MANAGER").build();
        UserDetails smith = User.builder().username("smith").password("{noop}smith").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(john, mary, smith);
    }
}
