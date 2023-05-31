package br.com.ecb.establishmentapi.shared.dtos.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.sql.Timestamp;

public class EstablishmentEmployeeDTOTest {

    @Test
    public void testEstablishmentEmployeeDTO() {
        BigInteger id = BigInteger.valueOf(1);
        BigInteger employeeId = BigInteger.valueOf(100);
        BigInteger establishmentId = BigInteger.valueOf(200);
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

        EstablishmentEmployeeDTO establishmentEmployeeDTO = new EstablishmentEmployeeDTO(id, employeeId, establishmentId, createdAt, updatedAt);

        Assertions.assertEquals(id, establishmentEmployeeDTO.getId());
        Assertions.assertEquals(employeeId, establishmentEmployeeDTO.getEmployeeId());
        Assertions.assertEquals(establishmentId, establishmentEmployeeDTO.getEstablishmentId());
        Assertions.assertEquals(createdAt, establishmentEmployeeDTO.getCreateAt());
        Assertions.assertEquals(updatedAt, establishmentEmployeeDTO.getUpdatedAt());
    }
}
