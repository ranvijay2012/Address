package org.spring.boot.utility;

import org.spring.boot.constant.ErrorDetails;
import org.spring.boot.constant.SuccessDetails;
import org.spring.boot.service.dto.ErrorDto;
import org.spring.boot.service.dto.ResponseDto;
import org.spring.boot.service.dto.SuccessDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil<I> {

    public ResponseEntity<ResponseDto<I>> getSuccessResponseWithDataDto(I data, SuccessDetails successDetails) {
        ResponseDto<I> responseDto = new ResponseDto<I>();
        SuccessDto<I> successDto = new SuccessDto<I>();
        successDto.setSuccessCode(successDetails.getCode());
        successDto.setSuccessMessage(successDetails.getMessage());
        successDto.setData(data);
        responseDto.setSuccessDto(successDto);
        return new ResponseEntity<>(responseDto, successDetails.getHttpStatus());
    }

    public ResponseEntity<ResponseDto<I>> getSuccessResponseDto(SuccessDetails successDetails) {
        ResponseDto<I> responseDto = new ResponseDto<I>();
        SuccessDto<I> successDto = new SuccessDto<I>();
        successDto.setSuccessCode(successDetails.getCode());
        successDto.setSuccessMessage(successDetails.getMessage());
        responseDto.setSuccessDto(successDto);
        return new ResponseEntity<>(responseDto, successDetails.getHttpStatus());
    }

    public ResponseEntity<ResponseDto<I>> populateErrorResponse(ErrorDetails errorDetails) {
        ResponseDto<I> responseDto = new ResponseDto<I>();
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorCode(errorDetails.getErrorCode());
        errorDto.setErrorMessage(errorDetails.getErrorMessage());
        responseDto.setErrorDto(errorDto);
        return new ResponseEntity<>(responseDto, errorDetails.getHttpStatus());
    }

}
