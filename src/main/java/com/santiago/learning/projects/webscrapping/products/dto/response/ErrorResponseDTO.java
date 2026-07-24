package com.santiago.learning.projects.webscrapping.products.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponseDTO {
    private Integer code;
    private LocalDateTime timestamp;
    private String message;
}
