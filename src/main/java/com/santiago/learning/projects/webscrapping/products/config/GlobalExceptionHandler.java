package com.santiago.learning.projects.webscrapping.products.config;

import java.time.LocalDateTime;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.santiago.learning.projects.webscrapping.products.dto.response.ErrorResponseDTO;
import com.santiago.learning.projects.webscrapping.products.enums.ErrorCodeEnum;
import com.santiago.learning.projects.webscrapping.products.exception.ProductsException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error("HTTP Method Not Supported: {}", ex.getMessage());
        String message = "Method " + ex.getMethod() + " is not supported for this endpoint.";
        ErrorResponseDTO payload = new ErrorResponseDTO(ErrorCodeEnum.UNHANDLED_ERROR.getCode(), LocalDateTime.now(), message);
        return new ResponseEntity<>(payload, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadRequestException(InvalidDataAccessApiUsageException ex) {
        log.error("Bad request exception: {}", ex.getMessage(), ex);

        ErrorResponseDTO payload = new ErrorResponseDTO(ErrorCodeEnum.UNHANDLED_ERROR.getCode(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(payload, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductsException.class)
    public ResponseEntity<ErrorResponseDTO> handleException(ProductsException ex) {
        log.error("Error encountered: {}", ex.getMessage(), ex);

        HttpStatus status = ex.getHttpStatus() == null ? HttpStatus.OK : ex.getHttpStatus();
        return new ResponseEntity<>(new ErrorResponseDTO(ex.getCode(), ex.getTimestamp(), ex.getMessage()), status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception e) {
        log.error("Unhandled error encountered: ", e); // Removed string replacement for better logging stack trace

        ProductsException ex = new ProductsException(ErrorCodeEnum.UNHANDLED_ERROR);
        return new ResponseEntity<>(new ErrorResponseDTO(ex.getCode(), ex.getTimestamp(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}