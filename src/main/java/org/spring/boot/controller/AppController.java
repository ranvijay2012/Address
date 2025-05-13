package org.spring.boot.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.spring.boot.constant.SuccessDetails;
import org.spring.boot.exception.ApplicationException;
import org.spring.boot.service.AddressService;
import org.spring.boot.service.dto.AddressDto;
import org.spring.boot.service.dto.ResponseDto;
import org.spring.boot.utility.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private ResponseUtil responseUtil;

    @Autowired
    private AddressService addressService;

    @GetMapping()
    @Operation(summary = "Welcome method")
    public String getWelcome() {
        log.info("INFO: This is a welcome message for address service");
        return "This is a welcome message for address service";
    }

    @GetMapping("/address/list")
    @Operation(summary = "Get all address list from DB")
    public ResponseEntity<ResponseDto<?>> getAddressList() {
        log.info("Get all employeeDtos list from DB");
        List<AddressDto> employeeDtos = addressService.getAddressList();
        return responseUtil.getSuccessResponseWithDataDto(employeeDtos, SuccessDetails.EMPLOYEE_LIST_GET_SUCCESSFULLY);
    }

    @GetMapping("/address/{id}")
    @Operation(summary = "Get only address from DB with id")
    public ResponseEntity<ResponseDto<?>> getAddress(@PathVariable("id") Long id) {
        log.info("Get only employeeDto from DB with id: {}", id);
        AddressDto addressDto = addressService.getAddress(id);
        return responseUtil.getSuccessResponseWithDataDto(addressDto, SuccessDetails.EMPLOYEE_GET_SUCCESSFULLY);
    }

    @PostMapping("/address")
    @Operation(summary = "Save employeeDto in DB")
    public ResponseEntity<ResponseDto<?>> saveAddress(@RequestBody AddressDto addressDto) throws ApplicationException {
        log.info("Save employeeDto in DB employeeDto is: {}", addressDto);
        AddressDto addressDto1 = addressService.saveAddress(addressDto);
        return responseUtil.getSuccessResponseWithDataDto(addressDto1, SuccessDetails.EMPLOYEE_SAVED_SUCCESSFULLY);
    }

    @DeleteMapping("/address/{id}")
    @Operation(summary = "Delete address from DB filtered with id")
    public ResponseEntity<ResponseDto<?>> deleteAddress(@PathVariable("empId") Long id) {
        log.info("Delete address in DB id is: {}", id);
        addressService.deleteAddress(id);
        return responseUtil.getSuccessResponseDto(SuccessDetails.EMPLOYEE_DELETED_SUCCESSFULLY);
    }
}
