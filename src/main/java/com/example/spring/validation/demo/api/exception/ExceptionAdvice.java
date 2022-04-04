package com.example.spring.validation.demo.api.exception;

import com.example.spring.validation.demo.payload.response.SingleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected SingleResult<Errors> methodArgumentNotValid(HttpServletRequest httpServletRequest, MethodArgumentNotValidException e) {

        return new SingleResult<>(e.getBindingResult());
    }

    /**
     * @valid 유효성 검사 통과하지 못하면 발생하는 예외
     */
    @ExceptionHandler(ApiParamNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected SingleResult<Errors> apiParamNotValid(HttpServletRequest httpServletRequest, ApiParamNotValidException e) {

        return new SingleResult<>(e.getErrors());
    }
}

