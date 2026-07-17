package com.example.library;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.library.repository")
public class LibApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibApplication.class, args);
    }
}