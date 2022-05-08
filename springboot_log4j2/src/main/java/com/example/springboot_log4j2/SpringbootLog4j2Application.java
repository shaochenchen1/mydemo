package com.example.springboot_log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootLog4j2Application {
    static Logger logger= LoggerFactory.getLogger(SpringApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringbootLog4j2Application.class, args);
        logger.error("1");
        logger.debug("32");
        logger.info("3434");
        logger.trace("444");
    }

}
