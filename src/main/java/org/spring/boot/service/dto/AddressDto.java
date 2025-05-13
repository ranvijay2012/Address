package org.spring.boot.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String add1;
    private String add2;
    private String city;
    private String state;
    private Integer pin;

}
