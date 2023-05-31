package br.com.ecb.establishmentapi.main.factories.controllers.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.ListEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.ListEstablishment;

public class ListEstablishmentControllerFactory {
    private ListEstablishment listEstablishmentService;

    public ListEstablishmentControllerFactory(ListEstablishment listEstablishmentService) {
        this.listEstablishmentService = listEstablishmentService;
    }

    public ListEstablishmentController makeListEstablishmentController() {
        return new ListEstablishmentController(listEstablishmentService);
    }
}
