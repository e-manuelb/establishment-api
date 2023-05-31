package br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee;

import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.DeleteEstablishmentEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.DeleteEstablishmentEmployeeById;

public class DeleteEstablishmentEmployeeByIdControllerFactory {
    private DeleteEstablishmentEmployeeById deleteEstablishmentEmployeeByIdService;

    public DeleteEstablishmentEmployeeByIdControllerFactory(DeleteEstablishmentEmployeeById deleteEstablishmentEmployeeByIdService) {
        this.deleteEstablishmentEmployeeByIdService = deleteEstablishmentEmployeeByIdService;
    }

    public DeleteEstablishmentEmployeeByIdController makeDeleteEstablishmentEmployeeByIdController() {
        return new DeleteEstablishmentEmployeeByIdController(deleteEstablishmentEmployeeByIdService);
    }
}
