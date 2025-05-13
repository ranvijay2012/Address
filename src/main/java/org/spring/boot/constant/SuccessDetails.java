package org.spring.boot.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessDetails {
    EMPLOYEE_LIST_GET_SUCCESSFULLY(HttpStatus.OK, "001", "Employee list get successfully"),
    EMPLOYEE_GET_SUCCESSFULLY(HttpStatus.OK, "002", "Employee get successfully"),
    EMPLOYEE_SAVED_SUCCESSFULLY(HttpStatus.CREATED, "003", "Employee saved successfully"),
    EMPLOYEE_DELETED_SUCCESSFULLY(HttpStatus.ACCEPTED, "004", "Employee deleted successfully");

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    SuccessDetails(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
