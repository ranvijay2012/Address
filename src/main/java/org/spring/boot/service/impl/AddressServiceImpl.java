package org.spring.boot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.spring.boot.constant.ErrorDetails;
import org.spring.boot.exception.ApplicationException;
import org.spring.boot.repository.AddressRepository;
import org.spring.boot.repository.entity.Address;
import org.spring.boot.service.AddressService;
import org.spring.boot.service.adopter.AddressAdopter;
import org.spring.boot.service.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressAdopter employeeAdopter;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressDto> getAddressList() {
        log.info("Getting address list from DB ");
        List<Address> addressList = addressRepository.findAll();
        log.info("Now converting address entity into dto");
        List<AddressDto> employeeDtos = employeeAdopter.mapOneTypeListToAnotherType(addressList, AddressDto.class);
        log.info("After converting entity to dto then return a dto list with size: {}", employeeDtos.size());
        return employeeDtos;
    }

    @Override
    public AddressDto getAddress(Long empId) {
        log.info("Getting address detail from DB with ID: {}", empId);
        Optional<Address> optionalEmployee = addressRepository.findById(empId);
        log.info("Fetched address detail successfully from DB");
        Address address = optionalEmployee.orElseGet(Address::new);
        log.info("Map address entity to dto and return data with ID: {}", empId);
        return (AddressDto) employeeAdopter.mapOneObjectToAnother(address, AddressDto.class);
    }

    @Override
    public AddressDto saveAddress(AddressDto employeeDto) throws ApplicationException {
        log.info("Map address dto into entity data is: {}", employeeDto);
        Address address = (Address) employeeAdopter.mapOneObjectToAnother(employeeDto, Address.class);
        try {
            log.info("address data saving in DB");
            address = addressRepository.save(address);
            log.info("address data saved successfully in DB with id: {}", address.getId());
        } catch (Exception ex) {
            log.error("address data could not be save due to {}", ex.getMessage());
            throw new ApplicationException(ErrorDetails.EMPLOYEE_DATA_UNABLE_TO_SAVE, ex);
        }
        log.info("Now converting entity to dto and return a dto");
        return (AddressDto) employeeAdopter.mapOneObjectToAnother(address, AddressDto.class);
    }

    @Override
    public void deleteAddress(Long id) {
        log.info("Deleting address detail from DB with ID: {}", id);
        addressRepository.deleteById(id);
        log.info("Deleted address detail from DB successfully");
    }
}
