package br.com.ecb.establishmentapi.main.routes.establishmentEmployee;

import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.SaveEstablishmentEmployeeController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.SaveEstablishmentEmployee;
import br.com.ecb.establishmentapi.domain.models.EstablishmentEmployee;
import br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee.SaveEstablishmentEmployeeControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.request.establishmentEmployee.SaveEstablishmentEmployeeDTO;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentEmployeeDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/establishment/employee")
public class SaveEstablishmentEmployeeRoute {
    private SaveEstablishmentEmployee saveEstablishmentEmployeeService;

    public SaveEstablishmentEmployeeRoute(SaveEstablishmentEmployee saveEstablishmentEmployeeService) {
        this.saveEstablishmentEmployeeService = saveEstablishmentEmployeeService;
    }

    @PostMapping("/")
    public EstablishmentEmployeeDTO perform(@RequestBody SaveEstablishmentEmployeeDTO saveEstablishmentEmployeeDTO) {
        SaveEstablishmentEmployeeController saveEstablishmentEmployeeController = new SaveEstablishmentEmployeeControllerFactory(saveEstablishmentEmployeeService).makeSaveEstablishmentEmployeeController();

        EstablishmentEmployee establishmentEmployee = saveEstablishmentEmployeeController.perform(
                new EstablishmentEmployee()
                        .setEmployeeId(saveEstablishmentEmployeeDTO.getEmployeeId())
                        .setEstablishmentId(saveEstablishmentEmployeeDTO.getEstablishmentId())
        );

        return new EstablishmentEmployeeDTO(
                establishmentEmployee.getId(),
                establishmentEmployee.getEmployeeId(),
                establishmentEmployee.getEstablishmentId(),
                establishmentEmployee.getCreatedAt(),
                establishmentEmployee.getUpdatedAt()
        );
    }
}
