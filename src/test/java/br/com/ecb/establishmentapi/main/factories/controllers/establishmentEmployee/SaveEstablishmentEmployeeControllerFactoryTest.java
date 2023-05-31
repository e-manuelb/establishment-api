package br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee;

import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.SaveEstablishmentEmployeeController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.SaveEstablishmentEmployee;
import br.com.ecb.establishmentapi.main.factories.controllers.establishmentEmployee.SaveEstablishmentEmployeeControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SaveEstablishmentEmployeeControllerFactoryTest {

    @Test
    public void testMakeSaveEstablishmentEmployeeController() {
        SaveEstablishmentEmployee saveEstablishmentEmployeeService = Mockito.mock(SaveEstablishmentEmployee.class);

        SaveEstablishmentEmployeeControllerFactory factory = new SaveEstablishmentEmployeeControllerFactory(saveEstablishmentEmployeeService);

        SaveEstablishmentEmployeeController controller = factory.makeSaveEstablishmentEmployeeController();

        Assertions.assertNotNull(controller);
    }
}

