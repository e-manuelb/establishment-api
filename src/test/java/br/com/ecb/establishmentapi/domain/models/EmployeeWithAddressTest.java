package br.com.ecb.establishmentapi.domain.models;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeWithAddressTest {
    @Test
    public void testEmployeeWithAddressCreation() {
        Employee employee = Mockito.mock(Employee.class);
        EmployeeAddress address = Mockito.mock(EmployeeAddress.class);
        when(employee.getName()).thenReturn("John Doe");
        when(address.getAddress()).thenReturn("123 Main St");

        EmployeeWithAddress employeeWithAddress = new EmployeeWithAddress(employee, address);

        assertEquals(employee, employeeWithAddress.getEmployee());
        assertEquals(address, employeeWithAddress.getAddress());

        assertEquals("John Doe", employeeWithAddress.getEmployee().getName());
        assertEquals("123 Main St", employeeWithAddress.getAddress().getAddress());
    }
}
