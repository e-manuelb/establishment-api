package br.com.ecb.establishmentapi.main.routes.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.FindEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.employee.FindEmployeeById;
import br.com.ecb.establishmentapi.domain.models.Employee;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.FindEmployeeByIdControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.response.EmployeeWithAddressDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FindEmployeeByIdRouteTest {

    @Test
    public void testPerform() throws Exception {
        FindEmployeeById findEmployeeByIdService = Mockito.mock(FindEmployeeById.class);

        BigInteger id = BigInteger.valueOf(123);

        Employee employee = new Employee(id, "John Doe", "photo-url", "123456789", "Manager", new Timestamp(123), new Timestamp(123));
        EmployeeWithAddress employeeWithAddress = new EmployeeWithAddress(employee, new EmployeeAddress(BigInteger.valueOf(1), "123 Main St", "City", "State", "12345", "12345", "12345", "12345", id, new Timestamp(123), new Timestamp(123)));

        Mockito.when(findEmployeeByIdService.perform(id)).thenReturn(employeeWithAddress);

        FindEmployeeByIdController findEmployeeByIdController = Mockito.mock(FindEmployeeByIdController.class);
        Mockito.when(findEmployeeByIdController.perform(id)).thenReturn(employeeWithAddress);

        FindEmployeeByIdControllerFactory findEmployeeByIdControllerFactory = Mockito.mock(FindEmployeeByIdControllerFactory.class);
        Mockito.when(findEmployeeByIdControllerFactory.makeFindEmployeeByIdController()).thenReturn(findEmployeeByIdController);

        FindEmployeeByIdRoute findEmployeeByIdRoute = new FindEmployeeByIdRoute(findEmployeeByIdService);

        EmployeeWithAddressDTO result = findEmployeeByIdRoute.perform(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getId());
        Assertions.assertEquals("John Doe", result.getName());
        Assertions.assertEquals("photo-url", result.getPhotoUrl());
        Assertions.assertEquals("123456789", result.getPhone());
        Assertions.assertEquals("Manager", result.getRole());
        Assertions.assertEquals(employee.getCreatedAt(), result.getCreatedAt());
        Assertions.assertEquals(employee.getUpdatedAt(), result.getUpdatedAt());
    }

    // Add more test cases if needed...

}


