package com.santiago.learning.projects.webscrapping.products.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    PRODUCT_NOT_FOUND(101, "Product id not found."),
    UNHANDLED_ERROR(100, "Unhandled exception");

    private final Integer code;
    private final String message;
}
