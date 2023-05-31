package br.com.ecb.establishmentapi.application.controllers.employee;

import br.com.ecb.establishmentapi.domain.features.employee.FindEmployeeById;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;

import java.math.BigInteger;

public class FindEmployeeByIdController {
    private FindEmployeeById findEmployeeByIdService;

    public FindEmployeeByIdController(FindEmployeeById findEmployeeByIdService) {
        this.findEmployeeByIdService = findEmployeeByIdService;
    }

    public EmployeeWithAddress perform(BigInteger id) throws Exception {
        return findEmployeeByIdService.perform(id);
    }
}
