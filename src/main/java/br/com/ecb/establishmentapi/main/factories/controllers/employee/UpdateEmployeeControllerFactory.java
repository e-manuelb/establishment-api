package br.com.ecb.establishmentapi.main.factories.controllers.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.UpdateEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.UpdateEmployee;

public class UpdateEmployeeControllerFactory {
    private UpdateEmployee updateEmployeeService;

    public UpdateEmployeeControllerFactory(UpdateEmployee updateEmployeeService) {
        this.updateEmployeeService = updateEmployeeService;
    }

    public UpdateEmployeeController makeUpdateEmployeeController() {
        return new UpdateEmployeeController(updateEmployeeService);
    }
}
