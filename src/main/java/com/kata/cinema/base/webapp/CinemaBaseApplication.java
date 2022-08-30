package com.kata.cinema.base.webapp;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({"com.kata.cinema.base"})
@EntityScan("com.kata.cinema.base.models")
@EnableTransactionManagement
@EnableJpaRepositories({"com.kata.cinema.base"})
public class CinemaBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaBaseApplication.class, args);
    }
}

