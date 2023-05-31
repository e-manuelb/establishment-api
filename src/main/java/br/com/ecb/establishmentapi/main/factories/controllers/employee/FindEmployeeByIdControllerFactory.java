package br.com.ecb.establishmentapi.main.factories.controllers.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.FindEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.employee.FindEmployeeById;

public class FindEmployeeByIdControllerFactory {
    private FindEmployeeById findEmployeeByIdService;

    public FindEmployeeByIdControllerFactory(FindEmployeeById findEmployeeByIdService) {
        this.findEmployeeByIdService = findEmployeeByIdService;
    }

    public FindEmployeeByIdController makeFindEmployeeByIdController() {
        return new FindEmployeeByIdController(findEmployeeByIdService);
    }
}
