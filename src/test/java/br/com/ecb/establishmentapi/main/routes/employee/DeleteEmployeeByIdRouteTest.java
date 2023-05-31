package br.com.ecb.establishmentapi.main.routes.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.DeleteEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.employee.DeleteEmployeeById;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.DeleteEmployeeByIdControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.Map;

public class DeleteEmployeeByIdRouteTest {

    @Test
    public void testPerform() {
        DeleteEmployeeById deleteEmployeeByIdService = Mockito.mock(DeleteEmployeeById.class);

        DeleteEmployeeByIdRoute deleteEmployeeByIdRoute = new DeleteEmployeeByIdRoute(deleteEmployeeByIdService);

        BigInteger id = BigInteger.valueOf(123);

        DeleteEmployeeByIdController deleteEmployeeByIdController = Mockito.mock(DeleteEmployeeByIdController.class);

        DeleteEmployeeByIdControllerFactory deleteEmployeeByIdControllerFactory = Mockito.mock(DeleteEmployeeByIdControllerFactory.class);
        Mockito.when(deleteEmployeeByIdControllerFactory.makeDeleteEmployeeByIdController()).thenReturn(deleteEmployeeByIdController);

        // Call the perform method
        Map<String, String> result = deleteEmployeeByIdRoute.perform(id);

        // Verify the result
        Assertions.assertNotNull(result);
        Assertions.assertEquals("Employee with ID #" + id + " was deleted successfully.", result.get("message"));
    }

}

