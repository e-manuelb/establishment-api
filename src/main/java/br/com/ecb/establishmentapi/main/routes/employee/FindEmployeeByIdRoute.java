package br.com.ecb.establishmentapi.main.routes.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.FindEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.employee.FindEmployeeById;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.FindEmployeeByIdControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.response.EmployeeWithAddressDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/v1/employee")
public class FindEmployeeByIdRoute {
    private FindEmployeeById findEmployeeByIdService;

    public FindEmployeeByIdRoute(FindEmployeeById findEmployeeByIdService) {
        this.findEmployeeByIdService = findEmployeeByIdService;
    }

    @GetMapping("/{id}")
    EmployeeWithAddressDTO perform(@PathVariable BigInteger id) throws Exception {
        FindEmployeeByIdController findEmployeeByIdController = new FindEmployeeByIdControllerFactory(findEmployeeByIdService).makeFindEmployeeByIdController();

        EmployeeWithAddress employeeWithAddress = findEmployeeByIdController.perform(id);

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
