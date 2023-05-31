package br.com.ecb.establishmentapi.main.factories.controllers.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.FindEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.employee.FindEmployeeById;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.FindEmployeeByIdControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FindEmployeeByIdControllerFactoryTest {

    @Test
    public void testMakeFindEmployeeByIdController() {
        FindEmployeeById findEmployeeByIdService = Mockito.mock(FindEmployeeById.class);

        FindEmployeeByIdControllerFactory factory = new FindEmployeeByIdControllerFactory(findEmployeeByIdService);

        FindEmployeeByIdController controller = factory.makeFindEmployeeByIdController();

        Assertions.assertNotNull(controller);
    }
}

