package br.com.ecb.establishmentapi.main.routes.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.UpdateEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.UpdateEstablishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import br.com.ecb.establishmentapi.shared.dtos.request.establishment.UpdateEstablishmentDTO;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentWithAddressDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

public class UpdateEstablishmentRouteTest {

    @Test
    public void testPerform() throws Exception {
        UpdateEstablishmentController updateEstablishmentController = Mockito.mock(UpdateEstablishmentController.class);
        UpdateEstablishment updateEstablishmentService = Mockito.mock(UpdateEstablishment.class);
        UpdateEstablishmentRoute updateEstablishmentRoute = new UpdateEstablishmentRoute(updateEstablishmentService);

        UpdateEstablishmentDTO updateEstablishmentDTO = new UpdateEstablishmentDTO();
        updateEstablishmentDTO.setEstablishmentId(BigInteger.valueOf(1));
        updateEstablishmentDTO.setName("Updated Establishment");
        updateEstablishmentDTO.setPhone("9876543210");

        EstablishmentWithAddress establishmentWithAddress = updateEstablishmentDTO.toEstablishmentWithAddress();

        doReturn(establishmentWithAddress).when(updateEstablishmentController).perform(Mockito.any(EstablishmentWithAddress.class));
        doReturn(establishmentWithAddress).when(updateEstablishmentService).perform(Mockito.any(EstablishmentWithAddress.class));

        EstablishmentWithAddressDTO result = updateEstablishmentRoute.perform(updateEstablishmentDTO);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getName()).isEqualTo("Updated Establishment");
        assertThat(result.getPhone()).isEqualTo("9876543210");
    }
}