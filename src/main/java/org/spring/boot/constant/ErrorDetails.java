package org.spring.boot.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorDetails {
    EMPLOYEE_DATA_UNABLE_TO_SAVE(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Employee data could not be saved"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Some thing is wrong from server side"),
    RUNTIME_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "003", "Some thing is wrong and get runtime exception");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    ErrorDetails(HttpStatus httpStatus, String errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
