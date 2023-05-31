package br.com.ecb.establishmentapi.domain.models;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstablishmentAddressTest {
    @Test
    public void testEstablishmentAddressCreation() {
        Establishment establishment = Mockito.mock(Establishment.class);
        EstablishmentAddress establishmentAddress = new EstablishmentAddress();

        establishmentAddress.setId(BigInteger.valueOf(1));
        establishmentAddress.setAddress("123 Main St");
        establishmentAddress.setNumber("10");
        establishmentAddress.setComplement("Apt 5");
        establishmentAddress.setNeighborhood("Downtown");
        establishmentAddress.setCep("12345-678");
        establishmentAddress.setCity("City");
        establishmentAddress.setState("State");
        establishmentAddress.setEstablishmentId(BigInteger.valueOf(1));

        assertEquals(BigInteger.valueOf(1), establishmentAddress.getId());
        assertEquals("123 Main St", establishmentAddress.getAddress());
        assertEquals("10", establishmentAddress.getNumber());
        assertEquals("Apt 5", establishmentAddress.getComplement());
        assertEquals("Downtown", establishmentAddress.getNeighborhood());
        assertEquals("12345-678", establishmentAddress.getCep());
        assertEquals("City", establishmentAddress.getCity());
        assertEquals("State", establishmentAddress.getState());
        assertEquals(BigInteger.valueOf(1), establishmentAddress.getEstablishmentId());

        establishmentAddress.setEstablishmentId(establishment.getId());

        assertEquals(establishment.getId(), establishmentAddress.getEstablishmentId());
    }
}

