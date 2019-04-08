package com.itgo.handler;

import com.itgo.exception.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Set;

/**
 * Create by xb
 * The file is [ ExceptionHandler] on [ x-file-system ] project
 * The file path is com.itgo.handler.ExceptionHandler
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/8 14:40
 * @description
 *      controller 增强
 */
@RestControllerAdvice
public class ControllerHandler {

    private Logger logger = LoggerFactory.getLogger(ControllerHandler.class);


    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        logger.info("<=========  init binder =========>");
        //日期处理
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
    }


    /**
     * 用来处理bean validation 异常
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ExceptionResponse resolveConstraintViolationException(ConstraintViolationException e, HttpServletRequest request){
        logger.error("请求URL：{} 发生异常：{}", request.getRequestURI(), e);
        return new ExceptionResponse(500,"请求参数有误",new Date(),e,request.getRequestURI());
    }
}
