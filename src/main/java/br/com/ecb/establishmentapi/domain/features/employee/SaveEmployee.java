package br.com.ecb.establishmentapi.domain.features.employee;

import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;

public interface SaveEmployee {
    EmployeeWithAddress perform(EmployeeWithAddress employeeWithAddress);
}
