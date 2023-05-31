package br.com.ecb.establishmentapi.application.controllers.establishment;

import br.com.ecb.establishmentapi.domain.features.establishment.DeleteEstablishmentById;

import java.math.BigInteger;

public class DeleteEstablishmentByIdController {
    private DeleteEstablishmentById deleteEstablishmentByIdService;

    public DeleteEstablishmentByIdController(DeleteEstablishmentById deleteEstablishmentByIdService) {
        this.deleteEstablishmentByIdService = deleteEstablishmentByIdService;
    }

    public void perform(BigInteger id) {
        deleteEstablishmentByIdService.perform(id);
    }
}
