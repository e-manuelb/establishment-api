package br.com.ecb.establishmentapi.main.factories.controllers.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.FindEstablishmentByIdController;
import br.com.ecb.establishmentapi.domain.features.establishment.FindEstablishmentById;

public class FindEstablishmentByIdControllerFactory {
    private FindEstablishmentById findEstablishmentByIdService;

    public FindEstablishmentByIdControllerFactory(FindEstablishmentById findEstablishmentByIdService) {
        this.findEstablishmentByIdService = findEstablishmentByIdService;
    }

    public FindEstablishmentByIdController makeFindEstablishmentByIdController() {
        return new FindEstablishmentByIdController(findEstablishmentByIdService);
    }
}
