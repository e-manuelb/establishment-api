package br.com.ecb.establishmentapi.main.factories.controllers.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.ListEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.ListEmployee;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.ListEmployeeControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListEmployeeControllerFactoryTest {

    @Test
    public void testMakeListEmployeeController() {
        ListEmployee listEmployeeService = Mockito.mock(ListEmployee.class);

        ListEmployeeControllerFactory factory = new ListEmployeeControllerFactory(listEmployeeService);

        ListEmployeeController controller = factory.makeListEmployeeController();

        Assertions.assertNotNull(controller);
    }
}

