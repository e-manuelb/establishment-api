package br.com.ecb.establishmentapi.main.factories.controllers.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.UpdateEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.UpdateEstablishment;

public class UpdateEstablishmentControllerFactory {
    private UpdateEstablishment updateEstablishmentService;

    public UpdateEstablishmentControllerFactory(UpdateEstablishment updateEstablishmentService) {
        this.updateEstablishmentService = updateEstablishmentService;
    }

    public UpdateEstablishmentController makeUpdateEstablishmentController() {
        return new UpdateEstablishmentController(updateEstablishmentService);
    }
}
