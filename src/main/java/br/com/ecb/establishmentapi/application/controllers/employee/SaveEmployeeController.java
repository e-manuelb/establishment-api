package br.com.ecb.establishmentapi.application.controllers.employee;

import br.com.ecb.establishmentapi.domain.features.employee.SaveEmployee;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;

public class SaveEmployeeController {
    private SaveEmployee saveEmployeeService;

    public SaveEmployeeController(SaveEmployee saveEmployeeService) {
        this.saveEmployeeService = saveEmployeeService;
    }

    public EmployeeWithAddress perform(EmployeeWithAddress employeeWithAddress) {
        return saveEmployeeService.perform(employeeWithAddress);
    }
}
