package br.com.ecb.establishmentapi.domain.models;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EstablishmentWithAddressTest {

    @Test
    public void testEstablishmentWithAddressCreation() {
        Establishment establishment = Mockito.mock(Establishment.class);
        EstablishmentAddress address = Mockito.mock(EstablishmentAddress.class);

        EstablishmentWithAddress establishmentWithAddress = new EstablishmentWithAddress(establishment, address);

        assertNotNull(establishmentWithAddress);
        assertEquals(establishment, establishmentWithAddress.getEstablishment());
        assertEquals(address, establishmentWithAddress.getAddress());
    }
}

