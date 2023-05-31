package br.com.ecb.establishmentapi.main.factories.controllers.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.UpdateEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.UpdateEmployee;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.UpdateEmployeeControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UpdateEmployeeControllerFactoryTest {

    @Test
    public void testMakeUpdateEmployeeController() {
        UpdateEmployee updateEmployeeService = Mockito.mock(UpdateEmployee.class);

        UpdateEmployeeControllerFactory factory = new UpdateEmployeeControllerFactory(updateEmployeeService);

        UpdateEmployeeController controller = factory.makeUpdateEmployeeController();

        Assertions.assertNotNull(controller);
    }
}

