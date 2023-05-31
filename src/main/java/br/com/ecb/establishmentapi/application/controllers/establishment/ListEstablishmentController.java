package br.com.ecb.establishmentapi.application.controllers.establishment;

import br.com.ecb.establishmentapi.domain.features.establishment.ListEstablishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;

import java.util.List;

public class ListEstablishmentController {
    private ListEstablishment listEstablishmentService;

    public ListEstablishmentController(ListEstablishment listEstablishmentService) {
        this.listEstablishmentService = listEstablishmentService;
    }

    public List<EstablishmentWithAddress> perform() {
        return listEstablishmentService.perform();
    }
}
