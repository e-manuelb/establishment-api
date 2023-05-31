package br.com.ecb.establishmentapi.main.factories.controllers.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.DeleteEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.employee.DeleteEmployeeById;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.DeleteEmployeeByIdControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DeleteEmployeeByIdControllerFactoryTest {

    @Test
    public void testMakeDeleteEmployeeByIdController() {
        DeleteEmployeeById deleteEmployeeByIdService = Mockito.mock(DeleteEmployeeById.class);

        DeleteEmployeeByIdControllerFactory factory = new DeleteEmployeeByIdControllerFactory(deleteEmployeeByIdService);

        DeleteEmployeeByIdController controller = factory.makeDeleteEmployeeByIdController();

        Assertions.assertNotNull(controller);
    }
}
