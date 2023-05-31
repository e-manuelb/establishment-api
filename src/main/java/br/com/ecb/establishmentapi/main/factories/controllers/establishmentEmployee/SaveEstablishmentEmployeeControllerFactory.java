package br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee;

import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.SaveEstablishmentEmployeeController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.SaveEstablishmentEmployee;

public class SaveEstablishmentEmployeeControllerFactory {
    private SaveEstablishmentEmployee saveEstablishmentEmployeeService;

    public SaveEstablishmentEmployeeControllerFactory(SaveEstablishmentEmployee saveEstablishmentEmployeeService) {
        this.saveEstablishmentEmployeeService = saveEstablishmentEmployeeService;
    }

    public SaveEstablishmentEmployeeController makeSaveEstablishmentEmployeeController() {
        return new SaveEstablishmentEmployeeController(saveEstablishmentEmployeeService);
    }
}
