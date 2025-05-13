package org.spring.boot.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessDetails {
    ADDRESS_LIST_GET_SUCCESSFULLY(HttpStatus.OK, "001", "Address list get successfully"),
    ADDRESS_GET_SUCCESSFULLY(HttpStatus.OK, "002", "Address get successfully"),
    ADDRESS_SAVED_SUCCESSFULLY(HttpStatus.CREATED, "003", "Address saved successfully"),
    ADDRESS_DELETED_SUCCESSFULLY(HttpStatus.ACCEPTED, "004", "Address deleted successfully");

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    SuccessDetails(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
