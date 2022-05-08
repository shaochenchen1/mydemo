package com.example.springboot_logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootLoggingApplication {

    static Logger logger= LoggerFactory.getLogger(SpringbootLoggingApplication.class);



    public static void main(String[] args) {
        SpringApplication.run(SpringbootLoggingApplication.class, args);
        logger.trace("跟踪");
        logger.debug("调试");
        //springboot 的默认输出级别是info
        logger.info("信息");
        logger.warn("警告");
        logger.error("异常");
    }

}
