package org.spring.boot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessDto<I>{
    private String successCode;
    private String successMessage;
    private I data;
}
