package com.example.spring.validation.demo.api.exception;

import lombok.Getter;
import org.springframework.validation.Errors;

@Getter
public class ApiParamNotValidException extends RuntimeException {

    private final Errors errors;

    public ApiParamNotValidException(Errors errors) {
        this.errors = errors;
    }
}
