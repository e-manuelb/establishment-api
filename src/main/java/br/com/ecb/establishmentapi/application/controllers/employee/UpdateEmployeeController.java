package br.com.ecb.establishmentapi.application.controllers.employee;

import br.com.ecb.establishmentapi.domain.features.employee.UpdateEmployee;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;

public class UpdateEmployeeController {
    private UpdateEmployee updateEmployeeService;

    public UpdateEmployeeController(UpdateEmployee updateEmployeeService) {
        this.updateEmployeeService = updateEmployeeService;
    }

    public EmployeeWithAddress perform(EmployeeWithAddress employeeWithAddress) throws Exception {
        return updateEmployeeService.perform(employeeWithAddress);
    }
}
