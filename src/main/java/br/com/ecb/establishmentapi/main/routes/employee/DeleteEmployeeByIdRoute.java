package br.com.ecb.establishmentapi.main.routes.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.DeleteEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.employee.DeleteEmployeeById;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.DeleteEmployeeByIdControllerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employee")
public class DeleteEmployeeByIdRoute {
    private DeleteEmployeeById deleteEmployeeByIdService;

    public DeleteEmployeeByIdRoute(DeleteEmployeeById deleteEmployeeByIdService) {
        this.deleteEmployeeByIdService = deleteEmployeeByIdService;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> perform(@PathVariable BigInteger id) {
        DeleteEmployeeByIdController deleteEmployeeByIdController = new DeleteEmployeeByIdControllerFactory(deleteEmployeeByIdService).makeDeleteEmployeeByIdController();

        try {
            deleteEmployeeByIdController.perform(id);
        } catch (Exception exception) {
            throw exception;
        }

        Map<String, String> message = new HashMap<>();

        message.put("message", "Employee with ID #" + id + " was deleted successfully.");

        return message;
    }
}
