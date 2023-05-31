package br.com.ecb.establishmentapi.application.controllers.establishmentEmployee;

import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.SaveEstablishmentEmployee;
import br.com.ecb.establishmentapi.domain.models.EstablishmentEmployee;

public class SaveEstablishmentEmployeeController {
    private SaveEstablishmentEmployee saveEstablishmentEmployeeService;

    public SaveEstablishmentEmployeeController(SaveEstablishmentEmployee saveEstablishmentEmployeeService) {
        this.saveEstablishmentEmployeeService = saveEstablishmentEmployeeService;
    }

    public EstablishmentEmployee perform(EstablishmentEmployee establishmentEmployee) {
        return saveEstablishmentEmployeeService.perform(establishmentEmployee);
    }
}
