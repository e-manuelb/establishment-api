package br.com.ecb.establishmentapi.domain.features.employee.address;

import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;

public interface SaveEmployeeAddress {
    EmployeeAddress perform(EmployeeAddress employeeAddress);
}
