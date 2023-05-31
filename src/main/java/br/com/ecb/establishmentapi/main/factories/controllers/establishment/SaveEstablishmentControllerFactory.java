package br.com.ecb.establishmentapi.main.factories.controllers.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.SaveEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.SaveEstablishment;

public class SaveEstablishmentControllerFactory {
    private SaveEstablishment saveEstablishmentService;

    public SaveEstablishmentControllerFactory(SaveEstablishment saveEstablishmentService) {
        this.saveEstablishmentService = saveEstablishmentService;
    }

    public SaveEstablishmentController makeSaveEstablishmentController() {
        return new SaveEstablishmentController(saveEstablishmentService);
    }
}
