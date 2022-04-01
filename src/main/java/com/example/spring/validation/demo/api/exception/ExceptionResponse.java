package com.example.spring.validation.demo.api.exception;

import lombok.Builder;
import lombok.Getter;

public class ExceptionResponse {

    @Getter
    public static class ApiParamNotValidExceptionRes {

        private String field;
        private String defaultMessage;

        @Builder
        public ApiParamNotValidExceptionRes(String field, String defaultMessage) {
            this.field = field;
            this.defaultMessage = defaultMessage;
        }
    }
}
