package br.com.ecb.establishmentapi.domain.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EmployeeTest {
    @Test
    public void testEmployeeCreation() {
        Employee employee = Mockito.mock(Employee.class);
        BigInteger id = BigInteger.valueOf(1);
        String name = "John Doe";
        String photoUrl = "https://example.com/photo.jpg";
        String phone = "1234567890";
        String role = "Manager";
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

        when(employee.getId()).thenReturn(id);
        when(employee.getName()).thenReturn(name);
        when(employee.getPhotoUrl()).thenReturn(photoUrl);
        when(employee.getPhone()).thenReturn(phone);
        when(employee.getRole()).thenReturn(role);
        when(employee.getCreatedAt()).thenReturn(createdAt);
        when(employee.getUpdatedAt()).thenReturn(updatedAt);

        assertEquals(id, employee.getId());
        assertEquals(name, employee.getName());
        assertEquals(photoUrl, employee.getPhotoUrl());
        assertEquals(phone, employee.getPhone());
        assertEquals(role, employee.getRole());
        assertEquals(createdAt, employee.getCreatedAt());
        assertEquals(updatedAt, employee.getUpdatedAt());
    }
}

