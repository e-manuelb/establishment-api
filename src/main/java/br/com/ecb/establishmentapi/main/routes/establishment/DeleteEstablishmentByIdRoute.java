package br.com.ecb.establishmentapi.main.routes.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.DeleteEstablishmentByIdController;
import br.com.ecb.establishmentapi.domain.features.establishment.DeleteEstablishmentById;
import br.com.ecb.establishmentapi.main.factories.controllers.establishment.DeleteEstablishmentByIdControllerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/establishment")
public class DeleteEstablishmentByIdRoute {
    private DeleteEstablishmentById deleteEstablishmentByIdService;

    public DeleteEstablishmentByIdRoute(DeleteEstablishmentById deleteEstablishmentByIdService) {
        this.deleteEstablishmentByIdService = deleteEstablishmentByIdService;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> perform(@PathVariable BigInteger id) {
        DeleteEstablishmentByIdController deleteEstablishmentByIdController = new DeleteEstablishmentByIdControllerFactory(deleteEstablishmentByIdService).makeDeleteEstablishmentByIdController();

        try {
            deleteEstablishmentByIdController.perform(id);
        } catch (Exception exception) {
            throw exception;
        }

        Map<String, String> message = new HashMap<>();

        message.put("message", "Establishment with ID #" + id + " was deleted successfully.");

        return message;
    }
}
