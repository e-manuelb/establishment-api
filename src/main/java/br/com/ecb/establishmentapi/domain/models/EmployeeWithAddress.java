package br.com.ecb.establishmentapi.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeWithAddress {
    private Employee employee;
    private EmployeeAddress address;
}
