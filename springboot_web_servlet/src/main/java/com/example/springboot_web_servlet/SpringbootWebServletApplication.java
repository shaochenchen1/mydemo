package com.example.springboot_web_servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringbootWebServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebServletApplication.class, args);
    }

}
