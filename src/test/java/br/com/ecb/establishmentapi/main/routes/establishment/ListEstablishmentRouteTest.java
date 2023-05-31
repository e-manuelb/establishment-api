package br.com.ecb.establishmentapi.main.routes.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.ListEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.ListEstablishment;
import br.com.ecb.establishmentapi.domain.models.Establishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentWithAddressDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

public class ListEstablishmentRouteTest {

    @Test
    public void testPerform() {
        ListEstablishmentController listEstablishmentController = Mockito.mock(ListEstablishmentController.class);
        ListEstablishment listEstablishmentService = Mockito.mock(ListEstablishment.class);
        ListEstablishmentRoute listEstablishmentRoute = new ListEstablishmentRoute(listEstablishmentService);

        List<EstablishmentWithAddress> establishmentWithAddresses = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
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

        Page<EstablishmentWithAddressDTO> result = listEstablishmentRoute.perform(0, 10);

        assertThat(result).isNotNull();
        assertThat(result.getTotalElements()).isEqualTo(20);
        assertThat(result.getTotalPages()).isEqualTo(2);
        assertThat(result.getNumber()).isEqualTo(0);
        assertThat(result.getSize()).isEqualTo(10);
        assertThat(result.getContent()).hasSize(10);

        EstablishmentWithAddressDTO establishmentDTO = result.getContent().get(0);
        assertThat(establishmentDTO.getId()).isEqualTo(1);
        assertThat(establishmentDTO.getName()).isEqualTo("Establishment 1");
        assertThat(establishmentDTO.getPhone()).isEqualTo("1234567890");

        establishmentDTO = result.getContent().get(9);
        assertThat(establishmentDTO.getId()).isEqualTo(10);
        assertThat(establishmentDTO.getName()).isEqualTo("Establishment 10");
        assertThat(establishmentDTO.getPhone()).isEqualTo("1234567890");
    }
}
