package br.com.ecb.establishmentapi.main.routes.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.ListEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.ListEstablishment;
import br.com.ecb.establishmentapi.domain.models.Establishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentWithAddressDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

public class ListEstablishmentWithoutPaginationRouteTest {

    @Test
    public void testPerform() {
        ListEstablishmentController listEstablishmentController = Mockito.mock(ListEstablishmentController.class);
        ListEstablishment listEstablishmentService = Mockito.mock(ListEstablishment.class);
        ListEstablishmentWithoutPaginationRoute listEstablishmentRoute = new ListEstablishmentWithoutPaginationRoute(listEstablishmentService);

        List<EstablishmentWithAddress> establishmentWithAddresses = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Establishment establishment = new Establishment();
            establishment.setId(BigInteger.valueOf(i));
            establishment.setName("Establishment " + i);
            establishment.setPhone("1234567890");

            EstablishmentAddress address = new EstablishmentAddress();
            address.setId(BigInteger.valueOf(i));
            address.setAddress("Main St " + i);
            address.setNumber(String.valueOf(i));
            address.setCity("City");
            address.setState("State");
            address.setCep("12345");

            EstablishmentWithAddress establishmentWithAddress = new EstablishmentWithAddress(establishment, address);
            establishmentWithAddresses.add(establishmentWithAddress);
        }

        doReturn(establishmentWithAddresses).when(listEstablishmentController).perform();
        doReturn(establishmentWithAddresses).when(listEstablishmentService).perform();

        List<EstablishmentWithAddressDTO> result = listEstablishmentRoute.perform();

        assertThat(result).isNotNull();
        assertThat(result).hasSize(5);

        EstablishmentWithAddressDTO establishmentDTO = result.get(0);
        assertThat(establishmentDTO.getId()).isEqualTo(1);
        assertThat(establishmentDTO.getName()).isEqualTo("Establishment 1");
        assertThat(establishmentDTO.getPhone()).isEqualTo("1234567890");

        establishmentDTO = result.get(4);
        assertThat(establishmentDTO.getId()).isEqualTo(5);
        assertThat(establishmentDTO.getName()).isEqualTo("Establishment 5");
        assertThat(establishmentDTO.getPhone()).isEqualTo("1234567890");
    }
}
