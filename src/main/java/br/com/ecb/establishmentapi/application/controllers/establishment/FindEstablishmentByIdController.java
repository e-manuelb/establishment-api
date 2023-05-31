package br.com.ecb.establishmentapi.application.controllers.establishment;

import br.com.ecb.establishmentapi.domain.features.establishment.FindEstablishmentById;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;

import java.math.BigInteger;

public class FindEstablishmentByIdController {
    private FindEstablishmentById findEstablishmentByIdService;

    public FindEstablishmentByIdController(FindEstablishmentById findEstablishmentByIdService) {
        this.findEstablishmentByIdService = findEstablishmentByIdService;
    }

    public EstablishmentWithAddress perform(BigInteger id) throws Exception {
        return findEstablishmentByIdService.perform(id);
    }
}
