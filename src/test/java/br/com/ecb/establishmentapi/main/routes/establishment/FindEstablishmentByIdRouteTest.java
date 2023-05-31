package br.com.ecb.establishmentapi.main.routes.establishment;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.ecb.establishmentapi.application.controllers.establishment.FindEstablishmentByIdController;
import br.com.ecb.establishmentapi.domain.features.establishment.FindEstablishmentById;
import br.com.ecb.establishmentapi.domain.models.Establishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentWithAddressDTO;

import java.math.BigInteger;

public class FindEstablishmentByIdRouteTest {

    @Test
    public void testPerform() throws Exception {
        FindEstablishmentByIdController findEstablishmentByIdController = Mockito.mock(FindEstablishmentByIdController.class);
        FindEstablishmentById findEstablishmentByIdService = Mockito.mock(FindEstablishmentById.class);
        FindEstablishmentByIdRoute findEstablishmentByIdRoute = new FindEstablishmentByIdRoute(findEstablishmentByIdService);

        BigInteger establishmentId = BigInteger.valueOf(1);

        Establishment establishment = new Establishment();
        establishment.setId(BigInteger.valueOf(1));
        establishment.setName("Test Establishment");
        establishment.setPhone("1234567890");

        EstablishmentAddress address = new EstablishmentAddress();
        address.setId(BigInteger.valueOf(1));
        address.setAddress("Main St");
        address.setNumber("123");
        address.setCity("City");
        address.setState("State");
        address.setCep("12345");

        EstablishmentWithAddress establishmentWithAddress = new EstablishmentWithAddress(establishment, address);

        doReturn(establishmentWithAddress).when(findEstablishmentByIdController).perform(establishmentId);
        doReturn(establishmentWithAddress).when(findEstablishmentByIdService).perform(establishmentId);

        EstablishmentWithAddressDTO result = findEstablishmentByIdRoute.perform(establishmentId);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(address.getId());
        assertThat(result.getName()).isEqualTo(establishment.getName());
        assertThat(result.getPhone()).isEqualTo(establishment.getPhone());
        assertThat(result.getAddress()).isNotNull();
        assertThat(result.getAddress().getAddress()).isEqualTo(address.getAddress());
        assertThat(result.getAddress().getNumber()).isEqualTo(address.getNumber());
        assertThat(result.getAddress().getCity()).isEqualTo(address.getCity());
        assertThat(result.getAddress().getState()).isEqualTo(address.getState());
        assertThat(result.getAddress().getCep()).isEqualTo(address.getCep());
        assertThat(result.getCreatedAt()).isEqualTo(establishment.getCreatedAt());
        assertThat(result.getUpdatedAt()).isEqualTo(establishment.getUpdatedAt());
    }
}

