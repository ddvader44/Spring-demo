package com.ddvader44.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student dishit = new Student(
                    "Dishit",
                    "dduggar06@gmail.com",
                    LocalDate.of(2002, Month.SEPTEMBER, 13)
            );


            Student archita = new Student(
                    "Archita",
                    "archita2k1@gmail.com",
                    LocalDate.of(2001, Month.SEPTEMBER, 13)
            );

            Student yathu = new Student(
                    "Yathu",
                    "yathu@gmail.com",
                    LocalDate.of(2000, Month.NOVEMBER, 1)
            );

            repository.saveAll(
                    List.of(dishit, archita, yathu)
            );

        };
    }
}
