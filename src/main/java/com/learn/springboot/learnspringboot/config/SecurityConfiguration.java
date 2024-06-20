package com.learn.springboot.learnspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {
    // Read data from DataSource
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    // Hard coded users
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails john = User.builder().username("john").password("{noop}john").roles("EMPLOYEE").build();
//        UserDetails mary = User.builder().username("mary").password("{noop}mary").roles("MANAGER").build();
//        UserDetails smith = User.builder().username("smith").password("{noop}smith").roles("EMPLOYEE","MANAGER","ADMIN").build();
//        return new InMemoryUserDetailsManager(john, mary, smith);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config ->
                config
                        .requestMatchers(HttpMethod.GET,"/api/v2/members").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/v2/members/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/v2/members").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/v2/members/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/v2/members/**").hasRole("ADMIN")
        );

        //http basic authentication
        http.httpBasic(Customizer.withDefaults());

        //csrf
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
