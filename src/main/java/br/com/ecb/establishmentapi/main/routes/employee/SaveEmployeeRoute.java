package br.com.ecb.establishmentapi.main.routes.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.SaveEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.SaveEmployee;
import br.com.ecb.establishmentapi.domain.models.Employee;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.SaveEmployeeControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.response.EmployeeWithAddressDTO;
import br.com.ecb.establishmentapi.shared.dtos.request.employee.SaveEmployeeDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class SaveEmployeeRoute {
    private SaveEmployee saveEmployeeService;

    public SaveEmployeeRoute(SaveEmployee saveEmployeeService) {
        this.saveEmployeeService = saveEmployeeService;
    }

    @PostMapping("/")
    EmployeeWithAddressDTO perform(@RequestBody SaveEmployeeDTO saveEmployeeDTO) {
        SaveEmployeeController saveEmployeeController = new SaveEmployeeControllerFactory(saveEmployeeService).makeSaveEmployeeController();

        EmployeeWithAddress employeeWithAddress = saveEmployeeController.perform(
                new EmployeeWithAddress(
                        new Employee()
                                .setName(saveEmployeeDTO.getName())
                                .setPhone(saveEmployeeDTO.getPhone())
                                .setPhotoUrl(saveEmployeeDTO.getPhotoUrl())
                                .setRole(saveEmployeeDTO.getRole()),
                        new EmployeeAddress()
                                .setAddress(saveEmployeeDTO.getAddress())
                                .setNumber(saveEmployeeDTO.getNumber())
                                .setComplement(saveEmployeeDTO.getComplement())
                                .setNeighborhood(saveEmployeeDTO.getNeighborhood())
                                .setCep(saveEmployeeDTO.getCep())
                                .setCity(saveEmployeeDTO.getCity())
                                .setState(saveEmployeeDTO.getState()))
        );

        System.out.println(employeeWithAddress);

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
