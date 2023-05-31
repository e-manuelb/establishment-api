package br.com.ecb.establishmentapi.domain.features.employee;

import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;

import java.math.BigInteger;

public interface FindEmployeeById {
    EmployeeWithAddress perform(BigInteger id) throws Exception;
}
