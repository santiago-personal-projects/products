package com.santiago.learning.projects.webscrapping.products.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    PRODUCT_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "Product id not found."),
    UNHANDLED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Unhandled exception");

    private final int code;
    private final String message;
}
