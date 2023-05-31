package br.com.ecb.establishmentapi.main.factories.controllers.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.DeleteEstablishmentByIdController;
import br.com.ecb.establishmentapi.domain.features.establishment.DeleteEstablishmentById;

public class DeleteEstablishmentByIdControllerFactory {
    private DeleteEstablishmentById deleteEstablishmentByIdService;

    public DeleteEstablishmentByIdControllerFactory(DeleteEstablishmentById deleteEstablishmentByIdService) {
        this.deleteEstablishmentByIdService = deleteEstablishmentByIdService;
    }

    public DeleteEstablishmentByIdController makeDeleteEstablishmentByIdController() {
        return new DeleteEstablishmentByIdController(deleteEstablishmentByIdService);
    }
}
