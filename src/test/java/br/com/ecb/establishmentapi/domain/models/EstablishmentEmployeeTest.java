package br.com.ecb.establishmentapi.domain.models;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstablishmentEmployeeTest {

    @Test
    public void testEstablishmentEmployeeCreation() {
        Employee employee = Mockito.mock(Employee.class);
        Establishment establishment = Mockito.mock(Establishment.class);

        EstablishmentEmployee establishmentEmployee = new EstablishmentEmployee();

        establishmentEmployee.setId(BigInteger.valueOf(1));
        establishmentEmployee.setEstablishmentId(BigInteger.valueOf(1));
        establishmentEmployee.setEmployeeId(BigInteger.valueOf(1));

        assertEquals(BigInteger.valueOf(1), establishmentEmployee.getId());
        assertEquals(BigInteger.valueOf(1), establishmentEmployee.getEstablishmentId());
        assertEquals(BigInteger.valueOf(1), establishmentEmployee.getEmployeeId());

        establishmentEmployee.setEmployeeId(employee.getId());
        establishmentEmployee.setEstablishmentId(establishment.getId());

        assertEquals(employee.getId(), establishmentEmployee.getEmployeeId());
        assertEquals(establishment.getId(), establishmentEmployee.getEstablishmentId());
    }
}

