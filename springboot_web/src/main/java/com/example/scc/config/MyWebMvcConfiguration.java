package com.example.scc.config;

import com.example.scc.interceptors.TimeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * @ClassName MyWebMvcConfiguration
 * @Description TODO
 * @Author Administrator
 * @DATE 2022/4/30 0030 17:04
 * @VERSION 1.0
 **/
@Configuration
public class MyWebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeInterceptor())   //添加时间拦截器
                .addPathPatterns("/**") //拦截映射规则
                .excludePathPatterns("/pages/**");  //设置排除的映射规则
    }
    /**
     *@Author ShaoChenChen
     *@Description //用cook通过url传递 locale来设置国际化
     *@Date 13:56 2022/5/1 0001
     *@Param []
     *@return org.springframework.web.servlet.LocaleResolver
     **/
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        // 可以设置过期时间
        cookieLocaleResolver.setCookieMaxAge(60 * 60 * 24 * 30);
        cookieLocaleResolver.setCookieName("locale");
        return cookieLocaleResolver;
    }

}
