package br.com.ecb.establishmentapi.main.routes.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.ListEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.ListEmployee;
import br.com.ecb.establishmentapi.domain.models.Employee;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import br.com.ecb.establishmentapi.main.factories.controllers.employee.ListEmployeeControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.response.EmployeeWithAddressDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ListEmployeeRouteTest {

    @Test
    public void testPerform() {
        ListEmployee listEmployeeService = Mockito.mock(ListEmployee.class);

        List<EmployeeWithAddress> employeesWithAddresses = new ArrayList<>();

        EmployeeAddress address = new EmployeeAddress(BigInteger.valueOf(1), "123 Main St", "City", "State", "12345", "12345", "12345", "12345", BigInteger.valueOf(1), new Timestamp(123), new Timestamp(123));

        employeesWithAddresses.add(
                new EmployeeWithAddress(
                        new Employee(BigInteger.valueOf(1), "John Doe", "photo-url", "123456789", "Manager", new Timestamp(123), new Timestamp(123)),
                        address
                )
        );

        employeesWithAddresses.add(
                new EmployeeWithAddress(
                        new Employee(BigInteger.valueOf(2), "Jane Smith", "photo-url", "987654321", "Employee", new Timestamp(123), new Timestamp(123)),
                        address
                )
        );

        ListEmployeeRoute listEmployeeRoute = new ListEmployeeRoute(listEmployeeService);

        Mockito.when(listEmployeeService.perform()).thenReturn(employeesWithAddresses);

        ListEmployeeController listEmployeeController = Mockito.mock(ListEmployeeController.class);
        Mockito.when(listEmployeeController.perform()).thenReturn(employeesWithAddresses);

        Page<EmployeeWithAddressDTO> result = listEmployeeRoute.perform(0, 10);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.getContent().size());

        EmployeeWithAddressDTO employee1 = result.getContent().get(0);

        Assertions.assertEquals(BigInteger.valueOf(1), employee1.getId());
        Assertions.assertEquals("John Doe", employee1.getName());
        Assertions.assertEquals("photo-url", employee1.getPhotoUrl());
        Assertions.assertEquals("123456789", employee1.getPhone());
        Assertions.assertEquals("Manager", employee1.getRole());

        EmployeeWithAddressDTO employee2 = result.getContent().get(1);

        Assertions.assertEquals(BigInteger.valueOf(2), employee2.getId());
        Assertions.assertEquals("Jane Smith", employee2.getName());
        Assertions.assertEquals("photo-url", employee2.getPhotoUrl());
        Assertions.assertEquals("987654321", employee2.getPhone());
        Assertions.assertEquals("Employee", employee2.getRole());
    }

    // Add more test cases if needed...

}

