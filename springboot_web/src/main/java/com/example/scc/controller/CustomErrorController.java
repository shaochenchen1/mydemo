package com.example.scc.controller;

import com.example.scc.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Controller
@RequestMapping("/error")
public class CustomErrorController extends AbstractErrorController {
    public CustomErrorController(ErrorAttributes errorAttributes, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorViewResolvers);
    }

    Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

    /**
     * 处理浏览器请求的
     * 加上异常日志记录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model = Collections
                .unmodifiableMap(getErrorAttributes(request, getErrorAttributeOptions()));
        response.setStatus(status.value());
        ModelAndView modelAndView = resolveErrorView(request, response, status, model);
        logger.error(model.get("trace").toString());
        return (modelAndView != null) ? modelAndView : new ModelAndView("error", model);
    }

    /**
     * 处理ajax
     * 修改返回类型：Result 完成
     * 加上异常日志记录
     *
     * @param request
     * @return
     */
    @RequestMapping
    @ResponseBody
    public Result error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        if (status == HttpStatus.NO_CONTENT) {
            return new Result(204, "No Content");
        }

        Map<String, Object> body = getErrorAttributes(request, getErrorAttributeOptions());
        String code = body.get("status").toString();
        String message = body.get("message").toString();
        logger.error(body.get("trace").toString());
        return new Result(Integer.parseInt(code), message);
    }


    /**
     * 异常信息的选项
     *
     * @return
     */
    protected ErrorAttributeOptions getErrorAttributeOptions() {
        ErrorAttributeOptions of = ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE,
                ErrorAttributeOptions.Include.STACK_TRACE,
                ErrorAttributeOptions.Include.EXCEPTION);
        return of;
    }


    @Override
    public String getErrorPath() {
        return null;
    }
}
