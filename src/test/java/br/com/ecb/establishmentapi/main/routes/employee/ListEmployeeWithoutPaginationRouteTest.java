package br.com.ecb.establishmentapi.main.routes.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.ListEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.ListEmployee;
import br.com.ecb.establishmentapi.domain.models.Employee;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import br.com.ecb.establishmentapi.shared.dtos.response.EmployeeWithAddressDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ListEmployeeWithoutPaginationRouteTest {

    @Test
    public void testPerform() {
        ListEmployeeController listEmployeeController = Mockito.mock(ListEmployeeController.class);
        ListEmployee listEmployeeService = Mockito.mock(ListEmployee.class);
        ListEmployeeWithoutPaginationRoute listEmployeeRoute = new ListEmployeeWithoutPaginationRoute(listEmployeeService);

        List<EmployeeWithAddress> employeesWithAddresses = new ArrayList<>();
        Employee employee = new Employee(BigInteger.valueOf(1), "John Doe", "photo1.jpg", "123456789", "Manager", null, null);
        EmployeeAddress employeeAddress = new EmployeeAddress(BigInteger.valueOf(1), "123 Main St", "City", "State", "12345", "12345", "12345", "12345", BigInteger.valueOf(1), new Timestamp(123), new Timestamp(123));
        employeesWithAddresses.add(new EmployeeWithAddress(employee, employeeAddress));

        when(listEmployeeService.perform()).thenReturn(employeesWithAddresses);

        when(listEmployeeController.perform()).thenReturn(employeesWithAddresses);

        List<EmployeeWithAddressDTO> result = listEmployeeRoute.perform();

        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);

        EmployeeWithAddressDTO employeeWithAddressDTO = result.get(0);

        assertThat(employeeWithAddressDTO.getId()).isEqualTo(employee.getId());
        assertThat(employeeWithAddressDTO.getName()).isEqualTo(employee.getName());
        assertThat(employeeWithAddressDTO.getPhotoUrl()).isEqualTo(employee.getPhotoUrl());
        assertThat(employeeWithAddressDTO.getPhone()).isEqualTo(employee.getPhone());
        assertThat(employeeWithAddressDTO.getRole()).isEqualTo(employee.getRole());
        assertThat(employeeWithAddressDTO.getCreatedAt()).isEqualTo(employee.getCreatedAt());
        assertThat(employeeWithAddressDTO.getUpdatedAt()).isEqualTo(employee.getUpdatedAt());
    }
}
