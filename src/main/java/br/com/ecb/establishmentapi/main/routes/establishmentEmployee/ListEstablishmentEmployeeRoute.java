package br.com.ecb.establishmentapi.main.routes.establishmentEmployee;

import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.ListEstablishmentEmployeeController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.ListEstablishmentEmployee;
import br.com.ecb.establishmentapi.domain.models.EstablishmentEmployee;
import br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee.ListEstablishmentEmployeeControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentEmployeeDTO;
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
@RequestMapping("/api/v1/establishment/employee")
public class ListEstablishmentEmployeeRoute {
    private ListEstablishmentEmployee listEstablishmentEmployeeService;

    public ListEstablishmentEmployeeRoute(ListEstablishmentEmployee listEstablishmentEmployeeService) {
        this.listEstablishmentEmployeeService = listEstablishmentEmployeeService;
    }

    @GetMapping
    public Page<EstablishmentEmployeeDTO> perform(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "15") int pageSize) {
        ListEstablishmentEmployeeController listEstablishmentEmployeeController = new ListEstablishmentEmployeeControllerFactory(listEstablishmentEmployeeService).makeListEstablishmentEmployeeController();

        List<EstablishmentEmployee> establishmentEmployees = listEstablishmentEmployeeController.perform();

        List<EstablishmentEmployeeDTO> establishmentEmployeeDTOS = new ArrayList<>();

        establishmentEmployees.forEach(establishmentEmployee -> {
            establishmentEmployeeDTOS.add(
                    new EstablishmentEmployeeDTO(
                            establishmentEmployee.getId(),
                            establishmentEmployee.getEmployeeId(),
                            establishmentEmployee.getEstablishmentId(),
                            establishmentEmployee.getCreatedAt(),
                            establishmentEmployee.getUpdatedAt()
                    )
            );
        });

        int startIndex = pageNumber * pageSize;
        int endIndex = Math.min(startIndex + pageSize, establishmentEmployeeDTOS.size());

        return new PageImpl<>(establishmentEmployeeDTOS.subList(startIndex, endIndex), PageRequest.of(pageNumber, pageSize), establishmentEmployeeDTOS.size());
    }
}
