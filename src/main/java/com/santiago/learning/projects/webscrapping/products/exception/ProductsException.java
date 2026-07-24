package com.santiago.learning.projects.webscrapping.products.exception;

import java.time.LocalDate;

import com.santiago.learning.projects.webscrapping.products.enums.ErrorCodeEnum;

import lombok.Getter;

@Getter
public class ProductsException extends RuntimeException {
    private Integer code; 
    private LocalDate timestamp; 
    public ProductsException(ErrorCodeEnum error) {
        super(error.getMessage());
        this.code = error.getCode();
        this.timestamp = LocalDate.now();
    }
}
