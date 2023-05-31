package br.com.ecb.establishmentapi.application.controllers.establishmentEmployee;

import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.ListEstablishmentEmployee;
import br.com.ecb.establishmentapi.domain.models.EstablishmentEmployee;

import java.util.List;

public class ListEstablishmentEmployeeController {
    private ListEstablishmentEmployee listEstablishmentEmployeeService;

    public ListEstablishmentEmployeeController(ListEstablishmentEmployee listEstablishmentEmployeeService) {
        this.listEstablishmentEmployeeService = listEstablishmentEmployeeService;
    }

    public List<EstablishmentEmployee> perform() {
        return listEstablishmentEmployeeService.perform();
    }
}
