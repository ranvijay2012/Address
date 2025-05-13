package org.spring.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.spring.boot.constant.ErrorDetails;
import org.spring.boot.service.dto.ResponseDto;
import org.spring.boot.utility.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ResponseUtil responseUtil;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleException(Exception exception) {
        log.error("Getting common server side exception and reason is: {}", exception.getMessage());
        return responseUtil.populateErrorResponse(ErrorDetails.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDto> handleRuntimeExceptionn(RuntimeException exception) {
        log.error("Getting common runtime exception and reason is: {}", exception.getMessage());
        return responseUtil.populateErrorResponse(ErrorDetails.RUNTIME_EXCEPTION);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ResponseDto<?>> handleApplicationException(ApplicationException exception) {
        log.error("Getting application exception and reason is: {}", exception.getThrowable().getMessage());
        return responseUtil.populateErrorResponse(exception.getErrorDetails());
    }

}
