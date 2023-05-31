package br.com.ecb.establishmentapi.main.factories.controllers.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.SaveEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.SaveEmployee;

public class SaveEmployeeControllerFactory {
    private SaveEmployee saveEmployeeService;

    public SaveEmployeeControllerFactory(SaveEmployee saveEmployeeService) {
        this.saveEmployeeService = saveEmployeeService;
    }

    public SaveEmployeeController makeSaveEmployeeController() {
        return new SaveEmployeeController(saveEmployeeService);
    }
}
