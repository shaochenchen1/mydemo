package com.example.scc.config;

import com.example.scc.interceptors.TimeInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;


//@ControllerAdvice
public class GeneralExceptionHandler {
    static Logger logger= LoggerFactory.getLogger(GeneralExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request,
                                        HttpServletResponse reponse, Exception ex,
                                        HandlerMethod handle) {
        System.out.println("全局异常处理");
        // 如果当前请求是ajax就返回json

        // 1.根据用户请求的处理方法，是否是一个返回json的处理方法
        //RestController restAnnotation = handle.getClass().getAnnotation(RestController.class); // 获得类上面的某个注解
        //ResponseBody responseBody = handle.getMethod().getAnnotation(ResponseBody.class);//获得方法上面的某个注解
        // if(restAnnotation!=null || responseBody!=null){ }

        // 2.可以根据请求头中的类型Content-Type包含application/json


        if (request.getHeader("Accept").indexOf("application/json") > -1) {
            // 可以直接输出json  reponse.getWriter().write();  或者集成jackson

            // 集成jackson的方式：
            //ModelAndView 同时支持视图返回和json返回
            // 这种方式就是返回json
            ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
            // 通常会根据不同的异常返回不同的编码
            modelAndView.addObject("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
            modelAndView.addObject("message", ex.getMessage());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("error");
            modelAndView.addObject("ex", ex);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error(sw.toString());
            System.out.println(sw.toString());   // 日志记录
            return modelAndView;
        }
    }
}