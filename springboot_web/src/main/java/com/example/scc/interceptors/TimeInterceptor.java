package com.example.scc.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @ClassName TimeInterceptor
 * @Description TODO 记录请求的执行时间
 * @Author Administrator
 * @DATE 2022/4/30 0030 16:46
 * @VERSION 1.0
 **/
public class TimeInterceptor implements HandlerInterceptor {
    static Logger logger= LoggerFactory.getLogger(TimeInterceptor.class);
    LocalDateTime beginTime;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //开始时间
        beginTime= LocalDateTime.now() ;
        logger.info("当前请求："+request.getRequestURI()+"；开始时间："+beginTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //结束时间
        LocalDateTime endTime=LocalDateTime.now();
        //计算两个时间的时间差
        Duration between = Duration.between(beginTime, endTime);
        //获得相差的毫秒数
        long l = between.toMillis();
        logger.info("当前请求:"+request.getRequestURI()+";执行时间："+l+"毫秒");

    }
}
