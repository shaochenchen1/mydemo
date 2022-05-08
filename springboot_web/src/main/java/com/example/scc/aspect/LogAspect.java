package com.example.scc.aspect;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


/**
 * @ClassName LogAspect
 * @Description TODO
 * @Author Administrator
 * @DATE 2022/4/30 0030 15:21
 * @VERSION 1.0
 **/
@Aspect
@Component
public class LogAspect {
    static Logger logger= LoggerFactory.getLogger(LogAspect.class);

    @Around("execution(* com.example.scc.controller.*.*(..)) && @annotation(apiOperation)")
    public Object around(ProceedingJoinPoint joinPoint, ApiOperation apiOperation) throws Throwable {
        StringBuilder loginfo=new StringBuilder("用户访问了：");
        LocalDateTime time=LocalDateTime.now();
        logger.info("");
        Class<?> controller = joinPoint.getThis().getClass();
        Api api = controller.getAnnotation(Api.class);
        if( api!=null) {
            loginfo.append(api.value());
        }
        String value = apiOperation.value();
        loginfo.append("--"+value);
        logger.info(loginfo.toString());
        return joinPoint.proceed();
    }
   /* private static final ThreadLocal<Long> startTimeThreadLocal =
        new NamedThreadLocal<Long>("ThreadLocal StartTime");
    // 声明一个切入点
    @Pointcut("execution(public * com.example.scc.controller..*.*(..))")
    public void aspect() {
    }


    @Before("aspect()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        long beginTime = System.currentTimeMillis();//1、开始时间
        startTimeThreadLocal.set(beginTime);		//线程绑定变量（该数据只有当前请求的线程可见）

        logger.debug("开始计时: {}  URI: {}  请求方式: {} 参数: {}" , new SimpleDateFormat("hh:mm:ss.SSS")
                .format(beginTime), request.getRequestURI(),request.getMethod(), JSONObject.toJSONString(joinPoint.getArgs()));


    }

    @AfterReturning("aspect()")
    public void logResultVOInfo(JoinPoint joinPoint) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
        long endTime = System.currentTimeMillis(); 	//2、结束时间

        logger.debug("结束时间: {}  耗时: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
                new SimpleDateFormat("hh:mm:ss.SSS").format(endTime), DateUtils.formatDateTime(endTime - beginTime),
                Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024,
                (Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024);

    }*/

}
