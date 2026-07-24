package com.santiago.learning.projects.webscrapping.products.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.santiago.learning.projects.webscrapping.products.enums.ErrorCodeEnum;

import lombok.Getter;

@Getter
public class ProductsException extends RuntimeException {
    private Integer code;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;

    public ProductsException(ErrorCodeEnum error) {
        super(error.getMessage());
        this.code = error.getCode();
        this.timestamp = LocalDateTime.now();
    }
    public ProductsException(ErrorCodeEnum error, HttpStatus httpStatus) {
        super(error.getMessage());
        this.code = error.getCode();
        this.timestamp = LocalDateTime.now();
        this.httpStatus = httpStatus;
    }
}
