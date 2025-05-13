package org.spring.boot.exception;

import lombok.Getter;
import org.spring.boot.constant.ErrorDetails;

@Getter
public class ApplicationException extends Exception{
    private final ErrorDetails errorDetails;
    private final Throwable throwable;

    public ApplicationException(ErrorDetails errorDetails, Throwable throwable){
        super(errorDetails.getErrorMessage());
        this.errorDetails = errorDetails;
        this.throwable = throwable;
    }
}
