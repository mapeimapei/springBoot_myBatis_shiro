package com.mapei.www.exception;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: GlobalExceptionHandler
 * Author:   longzhonghua
 * Date:     3/25/2019 10:54 PM
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 日志记录工具
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


        //捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Map<String, Object> ShiroException(ShiroException e) {
        logger.error("Unauthorized", e);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", 401);
        map.put("resultMsg", e.getMessage());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }

    //捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Map<String, Object> UnauthorizedException(ShiroException e) {
        logger.error("Unauthorized", e);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", 403);
        map.put("resultMsg", e.getMessage());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }


    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Map<String, Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.error("缺少请求参数", e);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", 502);
        map.put("resultMsg", e.getMessage());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", 501);
        map.put("resultMsg", e.getMessage());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("参数验证失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", 503);
        map.put("resultMsg", message);
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public Map<String, Object> handleBindException(BindException e) {
        logger.error("参数绑定失败", e);
        Map<String, Object> map = new HashMap<String, Object>();
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message =  String.format("%s:%s", field, code);
        map.put("resultCode", 504);
        map.put("resultMsg",message);
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }


    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, Object> handleServiceException(ConstraintViolationException e) {
        logger.error("参数验证失败", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String code = violation.getMessage();
        String getPropertyPath = violation.getPropertyPath().toString();
        int index = getPropertyPath.indexOf(".") + 1;
        int len = getPropertyPath.length();
        String field = getPropertyPath.substring(index,len);
        String message =  String.format("%s:%s", field, code);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", 505);
        map.put("resultMsg", message);
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Map<String, Object> handleValidationException(ValidationException e) {
        logger.error("参数验证失败", e);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", 506);
        map.put("resultMsg", e.getMessage());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String, Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", 405);
        map.put("resultMsg", e.getMessage());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Map<String, Object> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        logger.error("不支持当前媒体类型", e);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", 415);
        map.put("resultMsg", e.getMessage());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }

    /**
     * 自定义异常类
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Map<String, Object> businessExceptionHandler(BusinessException e) {
        logger.error("自定义业务失败", e);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", e.getCode());
        map.put("resultMsg", e.getMessage());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }


    /**
     * 获取其它异常。包括500
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> defaultErrorHandler(Exception e) {
        logger.error("Exception", e);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", 500);
        map.put("resultMsg", e.getMessage());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return map;
    }
}
