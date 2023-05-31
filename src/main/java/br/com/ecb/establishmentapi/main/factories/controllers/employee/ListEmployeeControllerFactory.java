package br.com.ecb.establishmentapi.main.factories.controllers.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.ListEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.ListEmployee;

public class ListEmployeeControllerFactory {
    private ListEmployee listEmployeeService;

    public ListEmployeeControllerFactory(ListEmployee listEmployeeService) {
        this.listEmployeeService = listEmployeeService;
    }

    public ListEmployeeController makeListEmployeeController() {
        return new ListEmployeeController(listEmployeeService);
    }
}
