package br.com.ecb.establishmentapi.application.controllers.establishment;

import br.com.ecb.establishmentapi.domain.features.establishment.SaveEstablishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;

public class SaveEstablishmentController {
    private SaveEstablishment saveEstablishmentService;

    public SaveEstablishmentController(SaveEstablishment saveEstablishmentService) {
        this.saveEstablishmentService = saveEstablishmentService;
    }

    public EstablishmentWithAddress perform(EstablishmentWithAddress establishmentWithAddress) {
        return saveEstablishmentService.perform(establishmentWithAddress);
    }
}
