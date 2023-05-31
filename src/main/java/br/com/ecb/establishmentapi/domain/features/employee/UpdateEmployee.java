package br.com.ecb.establishmentapi.domain.features.employee;

import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;

public interface UpdateEmployee {
    EmployeeWithAddress perform(EmployeeWithAddress employeeWithAddress) throws Exception;
}
