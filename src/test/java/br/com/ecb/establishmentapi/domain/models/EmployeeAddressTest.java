package br.com.ecb.establishmentapi.domain.models;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeAddressTest {
    @Test
    public void testEmployeeAddressCreation() {
        EmployeeAddress employeeAddress = Mockito.mock(EmployeeAddress.class);
        BigInteger id = BigInteger.valueOf(1);
        String address = "123 Main St";
        String number = "10A";
        String complement = "Apartment 5";
        String neighborhood = "Downtown";
        String cep = "12345-678";
        String city = "Example City";
        String state = "Example State";
        BigInteger employeeId = BigInteger.valueOf(1);
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

        when(employeeAddress.getId()).thenReturn(id);
        when(employeeAddress.getAddress()).thenReturn(address);
        when(employeeAddress.getNumber()).thenReturn(number);
        when(employeeAddress.getComplement()).thenReturn(complement);
        when(employeeAddress.getNeighborhood()).thenReturn(neighborhood);
        when(employeeAddress.getCep()).thenReturn(cep);
        when(employeeAddress.getCity()).thenReturn(city);
        when(employeeAddress.getState()).thenReturn(state);
        when(employeeAddress.getEmployeeId()).thenReturn(employeeId);
        when(employeeAddress.getCreatedAt()).thenReturn(createdAt);
        when(employeeAddress.getUpdatedAt()).thenReturn(updatedAt);

        assertEquals(id, employeeAddress.getId());
        assertEquals(address, employeeAddress.getAddress());
        assertEquals(number, employeeAddress.getNumber());
        assertEquals(complement, employeeAddress.getComplement());
        assertEquals(neighborhood, employeeAddress.getNeighborhood());
        assertEquals(cep, employeeAddress.getCep());
        assertEquals(city, employeeAddress.getCity());
        assertEquals(state, employeeAddress.getState());
        assertEquals(employeeId, employeeAddress.getEmployeeId());
        assertEquals(createdAt, employeeAddress.getCreatedAt());
        assertEquals(updatedAt, employeeAddress.getUpdatedAt());
    }
}

