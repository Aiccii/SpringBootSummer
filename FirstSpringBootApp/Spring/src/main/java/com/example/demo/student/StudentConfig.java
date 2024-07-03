package com.example.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Aichi = new Student( "Aichi", "elAichi@gmail.com",
                    LocalDate.of(2002, NOVEMBER, 29));

            Student Waleed = new Student( "Waleed", "elWaleed@gmail.com",
                    LocalDate.of(2013, AUGUST, 26));

            Student anas = new Student( "Anas", "elAnas@gmail.com",
                    LocalDate.of(2017, APRIL, 30));

            repository.saveAll(List.of(Aichi, Waleed, anas));

        };
    }
}
