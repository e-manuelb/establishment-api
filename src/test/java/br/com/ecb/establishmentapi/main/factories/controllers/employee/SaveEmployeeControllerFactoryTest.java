package br.com.ecb.establishmentapi.main.factories.controllers.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.SaveEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.SaveEmployee;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.SaveEmployeeControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SaveEmployeeControllerFactoryTest {

    @Test
    public void testMakeSaveEmployeeController() {
        SaveEmployee saveEmployeeService = Mockito.mock(SaveEmployee.class);

        SaveEmployeeControllerFactory factory = new SaveEmployeeControllerFactory(saveEmployeeService);

        SaveEmployeeController controller = factory.makeSaveEmployeeController();

        Assertions.assertNotNull(controller);
    }
}

