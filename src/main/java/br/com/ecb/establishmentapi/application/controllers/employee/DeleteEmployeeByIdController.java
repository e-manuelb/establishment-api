package br.com.ecb.establishmentapi.application.controllers.employee;

import br.com.ecb.establishmentapi.domain.features.employee.DeleteEmployeeById;

import java.math.BigInteger;

public class DeleteEmployeeByIdController {
    private DeleteEmployeeById deleteEmployeeByIdService;

    public DeleteEmployeeByIdController(DeleteEmployeeById deleteEmployeeByIdService) {
        this.deleteEmployeeByIdService = deleteEmployeeByIdService;
    }

    public void perform(BigInteger id) {
        deleteEmployeeByIdService.perform(id);
    }
}
