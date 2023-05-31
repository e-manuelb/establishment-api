package br.com.ecb.establishmentapi.main.routes.establishmentEmployee;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.SaveEstablishmentEmployeeController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.SaveEstablishmentEmployee;
import br.com.ecb.establishmentapi.domain.models.EstablishmentEmployee;
import br.com.ecb.establishmentapi.shared.dtos.request.establishmentEmployee.SaveEstablishmentEmployeeDTO;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentEmployeeDTO;

import java.math.BigInteger;
import java.sql.Timestamp;

public class SaveEstablishmentEmployeeRouteTest {

    @Test
    public void testPerform() {
        SaveEstablishmentEmployeeController saveEstablishmentEmployeeController = Mockito.mock(SaveEstablishmentEmployeeController.class);
        SaveEstablishmentEmployee saveEstablishmentEmployeeService = Mockito.mock(SaveEstablishmentEmployee.class);
        SaveEstablishmentEmployeeRoute saveEstablishmentEmployeeRoute = new SaveEstablishmentEmployeeRoute(saveEstablishmentEmployeeService);

        SaveEstablishmentEmployeeDTO saveEstablishmentEmployeeDTO = new SaveEstablishmentEmployeeDTO(BigInteger.valueOf(1), BigInteger.valueOf(1));

        EstablishmentEmployee establishmentEmployee = new EstablishmentEmployee(BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(1), new Timestamp(123), new Timestamp(123));

        doReturn(establishmentEmployee).when(saveEstablishmentEmployeeController).perform(Mockito.any(EstablishmentEmployee.class));
        doReturn(establishmentEmployee).when(saveEstablishmentEmployeeService).perform(Mockito.any(EstablishmentEmployee.class));

        EstablishmentEmployeeDTO result = saveEstablishmentEmployeeRoute.perform(saveEstablishmentEmployeeDTO);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getEmployeeId()).isEqualTo(1L);
        assertThat(result.getEstablishmentId()).isEqualTo(1L);
    }
}

