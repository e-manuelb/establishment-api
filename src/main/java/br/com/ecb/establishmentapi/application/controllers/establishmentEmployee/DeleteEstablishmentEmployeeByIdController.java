package br.com.ecb.establishmentapi.application.controllers.establishmentEmployee;

import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.DeleteEstablishmentEmployeeById;

import java.math.BigInteger;

public class DeleteEstablishmentEmployeeByIdController {
    private DeleteEstablishmentEmployeeById deleteEstablishmentEmployeeByIdService;

    public DeleteEstablishmentEmployeeByIdController(DeleteEstablishmentEmployeeById deleteEstablishmentEmployeeByIdService) {
        this.deleteEstablishmentEmployeeByIdService = deleteEstablishmentEmployeeByIdService;
    }

    public void perform(BigInteger id) {
        deleteEstablishmentEmployeeByIdService.perform(id);
    }
}
