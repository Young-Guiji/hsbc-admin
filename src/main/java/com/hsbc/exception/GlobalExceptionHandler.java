package com.hsbc.exception;

import com.hsbc.model.RestResp;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.List;


@RestControllerAdvice
@Order
public class GlobalExceptionHandler {
    /**
     * 系统自定义业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BaseBizException.class)
    public RestResp handle(BaseBizException e) {
        return RestResp.error(e.getErrorCode(), e.getErrorMsg());
    }


}