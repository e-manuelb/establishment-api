package br.com.ecb.establishmentapi.main.routes.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.ListEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.ListEmployee;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.ListEmployeeControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.response.EmployeeWithAddressDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class ListEmployeeRoute {
    private ListEmployee listEmployeeService;

    public ListEmployeeRoute(ListEmployee listEmployeeService) {
        this.listEmployeeService = listEmployeeService;
    }

    @GetMapping
    public Page<EmployeeWithAddressDTO> perform(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "15") int pageSize) {
        ListEmployeeController listEmployeeController = new ListEmployeeControllerFactory(listEmployeeService).makeListEmployeeController();

        List<EmployeeWithAddress> employeesWithAddresses = listEmployeeController.perform();

        List<EmployeeWithAddressDTO> employeesWithAddressesDTO = new ArrayList<>();

        employeesWithAddresses.forEach(employeeWithAddress -> {
            employeesWithAddressesDTO.add(
                    new EmployeeWithAddressDTO(
                            employeeWithAddress.getEmployee().getId(),
                            employeeWithAddress.getEmployee().getName(),
                            employeeWithAddress.getEmployee().getPhotoUrl(),
                            employeeWithAddress.getEmployee().getPhone(),
                            employeeWithAddress.getEmployee().getRole(),
                            employeeWithAddress.getAddress(),
                            employeeWithAddress.getEmployee().getCreatedAt(),
                            employeeWithAddress.getEmployee().getUpdatedAt()
                    )
            );
        });

        int startIndex = pageNumber * pageSize;
        int endIndex = Math.min(startIndex + pageSize, employeesWithAddressesDTO.size());

        return new PageImpl<>(employeesWithAddressesDTO.subList(startIndex, endIndex), PageRequest.of(pageNumber, pageSize), employeesWithAddressesDTO.size());
    }
}
