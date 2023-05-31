package br.com.ecb.establishmentapi.main.routes.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.UpdateEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.UpdateEmployee;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.UpdateEmployeeControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.response.EmployeeWithAddressDTO;
import br.com.ecb.establishmentapi.shared.dtos.request.employee.UpdateEmployeeDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class UpdateEmployeeRoute {
    private UpdateEmployee updateEmployeeService;

    public UpdateEmployeeRoute(UpdateEmployee updateEmployeeService) {
        this.updateEmployeeService = updateEmployeeService;
    }

    @PutMapping("/")
    EmployeeWithAddressDTO perform(@RequestBody UpdateEmployeeDTO updateEmployeeDTO) throws Exception {
        UpdateEmployeeController updateEmployeeController = new UpdateEmployeeControllerFactory(updateEmployeeService).makeUpdateEmployeeController();

        EmployeeWithAddress employeeWithAddress = updateEmployeeController.perform(updateEmployeeDTO.toEmployeeWithAddress());

        return new EmployeeWithAddressDTO(
                employeeWithAddress.getEmployee().getId(),
                employeeWithAddress.getEmployee().getName(),
                employeeWithAddress.getEmployee().getPhotoUrl(),
                employeeWithAddress.getEmployee().getPhone(),
                employeeWithAddress.getEmployee().getRole(),
                employeeWithAddress.getAddress(),
                employeeWithAddress.getEmployee().getCreatedAt(),
                employeeWithAddress.getEmployee().getUpdatedAt()
        );
    }
}
