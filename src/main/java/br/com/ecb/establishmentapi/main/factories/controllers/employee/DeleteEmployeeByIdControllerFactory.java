package br.com.ecb.establishmentapi.main.factories.controllers.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.DeleteEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.employee.DeleteEmployeeById;

public class DeleteEmployeeByIdControllerFactory {
    private DeleteEmployeeById deleteEmployeeByIdService;

    public DeleteEmployeeByIdControllerFactory(DeleteEmployeeById deleteEmployeeByIdService) {
        this.deleteEmployeeByIdService = deleteEmployeeByIdService;
    }

    public DeleteEmployeeByIdController makeDeleteEmployeeByIdController() {
        return new DeleteEmployeeByIdController(deleteEmployeeByIdService);
    }
}
