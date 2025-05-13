package org.spring.boot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<I>{
    private SuccessDto<I> successDto;
    private ErrorDto errorDto;
}