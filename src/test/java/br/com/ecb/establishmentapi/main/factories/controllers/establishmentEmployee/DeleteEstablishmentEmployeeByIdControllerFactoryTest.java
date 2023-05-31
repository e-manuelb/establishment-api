package br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee;

import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.DeleteEstablishmentEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.DeleteEstablishmentEmployeeById;
import br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee.DeleteEstablishmentEmployeeByIdControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DeleteEstablishmentEmployeeByIdControllerFactoryTest {

    @Test
    public void testMakeDeleteEstablishmentEmployeeByIdController() {
        DeleteEstablishmentEmployeeById deleteEstablishmentEmployeeByIdService = Mockito.mock(DeleteEstablishmentEmployeeById.class);

        DeleteEstablishmentEmployeeByIdControllerFactory factory = new DeleteEstablishmentEmployeeByIdControllerFactory(deleteEstablishmentEmployeeByIdService);

        DeleteEstablishmentEmployeeByIdController controller = factory.makeDeleteEstablishmentEmployeeByIdController();

        Assertions.assertNotNull(controller);
    }
}

