package br.com.ecb.establishmentapi.application.controllers.employee;

import br.com.ecb.establishmentapi.domain.features.employee.ListEmployee;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;

import java.util.List;

public class ListEmployeeController {
    private ListEmployee listEmployeeService;

    public ListEmployeeController(ListEmployee listEmployeeService) {
        this.listEmployeeService = listEmployeeService;
    }

    public List<EmployeeWithAddress> perform() {
        return listEmployeeService.perform();
    }
}
