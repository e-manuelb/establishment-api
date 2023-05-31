package br.com.ecb.establishmentapi.domain.features.employee;

import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;

import java.util.List;

public interface ListEmployee {
    List<EmployeeWithAddress> perform();
}
