package br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee;

import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.ListEstablishmentEmployeeController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.ListEstablishmentEmployee;
import br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee.ListEstablishmentEmployeeControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListEstablishmentEmployeeControllerFactoryTest {

    @Test
    public void testMakeListEstablishmentEmployeeController() {
        ListEstablishmentEmployee listEstablishmentEmployeeService = Mockito.mock(ListEstablishmentEmployee.class);

        ListEstablishmentEmployeeControllerFactory factory = new ListEstablishmentEmployeeControllerFactory(listEstablishmentEmployeeService);

        ListEstablishmentEmployeeController controller = factory.makeListEstablishmentEmployeeController();

        Assertions.assertNotNull(controller);
    }
}

