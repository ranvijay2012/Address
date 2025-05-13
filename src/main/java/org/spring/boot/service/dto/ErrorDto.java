package org.spring.boot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ErrorDto{
    private final Long timestamp;
    private String errorMessage;
    private String errorCode;

    public ErrorDto(){
        timestamp = Instant.now().getEpochSecond();
    }
}