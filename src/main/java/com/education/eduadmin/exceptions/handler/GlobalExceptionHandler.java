package com.education.eduadmin.exceptions.handler;

import ch.qos.logback.classic.spi.ConfiguratorRank;
import com.education.eduadmin.exceptions.custom.ResourceNotFoundException;
import com.education.eduadmin.exceptions.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ConfiguratorRank status;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        return buildResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND,
                request);
    }




    private ResponseEntity<ApiResponse> buildResponse(String message, HttpStatus httpStatus, WebRequest request) {
        ApiResponse<Object> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        response.setTimestamp(System.currentTimeMillis());
        response.setErrors("Resource not found");
        response.setErrorCode(status.value());
        response.setPath(path);
        response.setData(null);
        return new ResponseEntity<>(response, httpStatus);
    }

}
