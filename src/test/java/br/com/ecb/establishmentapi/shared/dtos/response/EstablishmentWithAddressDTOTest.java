package br.com.ecb.establishmentapi.shared.dtos.response;

import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.sql.Timestamp;

public class EstablishmentWithAddressDTOTest {

    @Test
    public void testEstablishmentWithAddressDTO() {
        BigInteger id = BigInteger.valueOf(1);
        String name = "Establishment";
        String phone = "1234567890";
        EstablishmentAddress address = new EstablishmentAddress();
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

        EstablishmentWithAddressDTO establishmentWithAddressDTO = new EstablishmentWithAddressDTO(id, name, phone, address, createdAt, updatedAt);

        Assertions.assertEquals(id, establishmentWithAddressDTO.getId());
        Assertions.assertEquals(name, establishmentWithAddressDTO.getName());
        Assertions.assertEquals(phone, establishmentWithAddressDTO.getPhone());
        Assertions.assertEquals(address, establishmentWithAddressDTO.getAddress());
        Assertions.assertEquals(createdAt, establishmentWithAddressDTO.getCreatedAt());
        Assertions.assertEquals(updatedAt, establishmentWithAddressDTO.getUpdatedAt());
    }
}
