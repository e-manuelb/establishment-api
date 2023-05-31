package br.com.ecb.establishmentapi.main.routes.establishment;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.ecb.establishmentapi.application.controllers.establishment.SaveEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.SaveEstablishment;
import br.com.ecb.establishmentapi.domain.models.Establishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import br.com.ecb.establishmentapi.shared.dtos.request.establishment.SaveEstablishmentDTO;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentWithAddressDTO;

import java.math.BigInteger;

public class SaveEstablishmentRouteTest {

    @Test
    public void testPerform() {
        SaveEstablishmentController saveEstablishmentController = Mockito.mock(SaveEstablishmentController.class);
        SaveEstablishment saveEstablishmentService = Mockito.mock(SaveEstablishment.class);
        SaveEstablishmentRoute saveEstablishmentRoute = new SaveEstablishmentRoute(saveEstablishmentService);

        SaveEstablishmentDTO saveEstablishmentDTO = new SaveEstablishmentDTO();
        saveEstablishmentDTO.setName("Test Establishment");
        saveEstablishmentDTO.setPhone("1234567890");
        saveEstablishmentDTO.setAddress("Main St");
        saveEstablishmentDTO.setNumber("123");

        Establishment establishment = new Establishment();
        establishment.setId(BigInteger.valueOf(1));
        establishment.setName(saveEstablishmentDTO.getName());
        establishment.setPhone(saveEstablishmentDTO.getPhone());

        EstablishmentAddress address = new EstablishmentAddress();
        address.setId(BigInteger.valueOf(1));
        address.setAddress(saveEstablishmentDTO.getAddress());
        address.setNumber(saveEstablishmentDTO.getNumber());

        EstablishmentWithAddress establishmentWithAddress = new EstablishmentWithAddress(establishment, address);

        doReturn(establishmentWithAddress).when(saveEstablishmentController).perform(Mockito.any(EstablishmentWithAddress.class));
        doReturn(establishmentWithAddress).when(saveEstablishmentService).perform(Mockito.any(EstablishmentWithAddress.class));

        EstablishmentWithAddressDTO result = saveEstablishmentRoute.perform(saveEstablishmentDTO);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getName()).isEqualTo("Test Establishment");
        assertThat(result.getPhone()).isEqualTo("1234567890");
    }
}

