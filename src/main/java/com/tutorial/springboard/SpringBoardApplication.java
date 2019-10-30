package com.tutorial.springboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoardApplication.class, args);
        System.out.printf("server start : http://localhost:8080/board/list");
    }
}
