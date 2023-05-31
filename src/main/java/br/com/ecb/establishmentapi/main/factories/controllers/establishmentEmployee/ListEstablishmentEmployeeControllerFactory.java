package br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee;

import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.ListEstablishmentEmployeeController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.ListEstablishmentEmployee;

public class ListEstablishmentEmployeeControllerFactory {
    private ListEstablishmentEmployee listEstablishmentEmployeeService;

    public ListEstablishmentEmployeeControllerFactory(ListEstablishmentEmployee listEstablishmentEmployeeService) {
        this.listEstablishmentEmployeeService = listEstablishmentEmployeeService;
    }

    public ListEstablishmentEmployeeController makeListEstablishmentEmployeeController() {
        return new ListEstablishmentEmployeeController(listEstablishmentEmployeeService);
    }
}
