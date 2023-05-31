package br.com.ecb.establishmentapi.application.controllers.establishment;

import br.com.ecb.establishmentapi.domain.features.establishment.UpdateEstablishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;

public class UpdateEstablishmentController {
    private UpdateEstablishment updateEstablishmentService;

    public UpdateEstablishmentController(UpdateEstablishment updateEstablishmentService) {
        this.updateEstablishmentService = updateEstablishmentService;
    }

    public EstablishmentWithAddress perform(EstablishmentWithAddress establishmentWithAddress) throws Exception {
        return updateEstablishmentService.perform(establishmentWithAddress);
    }
}
