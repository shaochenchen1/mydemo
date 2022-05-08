package com.example.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyWebMvcConfigurer
 * @Description TODO
 * @Author Administrator
 * @DATE 2022/5/6 0006 12:08
 * @VERSION 1.0
 **/
@Configuration
public class MyWebMvcConfigurer {
   /* public ServletRegistrationBean myServlet(){
        // 声明一个servlet注册器Bean
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        // 设置相应的servlet
        servletRegistrationBean.setServlet(new BeanServlet());
        // 设置名字
        servletRegistrationBean.setName("BeanServlet");
        // 添加映射规则
        servletRegistrationBean.addUrlMappings("/BeanServlet");
        return servletRegistrationBean;

    }*/
}
