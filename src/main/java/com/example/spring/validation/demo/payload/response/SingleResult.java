package com.example.spring.validation.demo.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResult<T> {

    private T data;

    public SingleResult(T data) {
        this.data = data;
    }
}
