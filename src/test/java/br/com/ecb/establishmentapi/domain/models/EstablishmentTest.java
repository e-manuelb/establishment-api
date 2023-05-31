package br.com.ecb.establishmentapi.domain.models;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstablishmentTest {

    @Test
    public void testEstablishmentCreation() {
        Establishment establishment = new Establishment();

        establishment.setId(BigInteger.valueOf(1));
        establishment.setName("Example Establishment");
        establishment.setPhone("123-456-7890");

        assertEquals(BigInteger.valueOf(1), establishment.getId());
        assertEquals("Example Establishment", establishment.getName());
        assertEquals("123-456-7890", establishment.getPhone());
    }
}