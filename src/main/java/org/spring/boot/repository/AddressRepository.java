package org.spring.boot.repository;

import org.spring.boot.repository.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Override
    Optional<Address> findById(Long empId);
}
