package org.spring.boot.service;


import org.spring.boot.exception.ApplicationException;
import org.spring.boot.service.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> getAddressList();

    AddressDto getAddress(Long empId);

    AddressDto saveAddress(AddressDto employeeDto) throws ApplicationException;

    void deleteAddress(Long id);
}
