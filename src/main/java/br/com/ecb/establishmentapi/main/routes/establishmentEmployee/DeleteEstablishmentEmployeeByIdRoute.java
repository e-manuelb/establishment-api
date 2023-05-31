package br.com.ecb.establishmentapi.main.routes.establishmentEmployee;

import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.DeleteEstablishmentEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.DeleteEstablishmentEmployeeById;
import br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee.DeleteEstablishmentEmployeeByIdControllerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/establishment/employee")
public class DeleteEstablishmentEmployeeByIdRoute {
    private DeleteEstablishmentEmployeeById deleteEstablishmentEmployeeByIdService;

    public DeleteEstablishmentEmployeeByIdRoute(DeleteEstablishmentEmployeeById deleteEstablishmentEmployeeByIdService) {
        this.deleteEstablishmentEmployeeByIdService = deleteEstablishmentEmployeeByIdService;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> perform(@PathVariable BigInteger id) {
        DeleteEstablishmentEmployeeByIdController deleteEstablishmentEmployeeByIdController = new DeleteEstablishmentEmployeeByIdControllerFactory(deleteEstablishmentEmployeeByIdService).makeDeleteEstablishmentEmployeeByIdController();

        try {
            deleteEstablishmentEmployeeByIdController.perform(id);
        } catch (Exception exception) {
            throw exception;
        }

        Map<String, String> message = new HashMap<>();

        message.put("message", "Establishment Employee with ID #" + id + " was deleted successfully.");

        return message;
    }
}
