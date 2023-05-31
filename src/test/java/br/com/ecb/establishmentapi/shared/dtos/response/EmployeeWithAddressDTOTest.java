package br.com.ecb.establishmentapi.shared.dtos.response;

import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.sql.Timestamp;

public class EmployeeWithAddressDTOTest {
    @Test
    public void testEmployeeWithAddressDTO() {
        BigInteger id = BigInteger.valueOf(1);
        String name = "John Doe";
        String photoUrl = "http://example.com/photo.jpg";
        String phone = "1234567890";
        String role = "Manager";
        EmployeeAddress address = new EmployeeAddress();
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

        EmployeeWithAddressDTO employeeWithAddressDTO = new EmployeeWithAddressDTO(id, name, photoUrl, phone, role, address, createdAt, updatedAt);

        Assertions.assertEquals(id, employeeWithAddressDTO.getId());
        Assertions.assertEquals(name, employeeWithAddressDTO.getName());
        Assertions.assertEquals(photoUrl, employeeWithAddressDTO.getPhotoUrl());
        Assertions.assertEquals(phone, employeeWithAddressDTO.getPhone());
        Assertions.assertEquals(role, employeeWithAddressDTO.getRole());
        Assertions.assertEquals(address, employeeWithAddressDTO.getAddress());
        Assertions.assertEquals(createdAt, employeeWithAddressDTO.getCreatedAt());
        Assertions.assertEquals(updatedAt, employeeWithAddressDTO.getUpdatedAt());
    }
}
