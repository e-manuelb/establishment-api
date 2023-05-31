package br.com.ecb.establishmentapi.main.routes.establishmentEmployee;

import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.ListEstablishmentEmployeeController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.ListEstablishmentEmployee;
import br.com.ecb.establishmentapi.domain.models.EstablishmentEmployee;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentEmployeeDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

public class ListEstablishmentEmployeeRouteTest {

    @Test
    public void testPerform() {
        ListEstablishmentEmployeeController listEstablishmentEmployeeController = Mockito.mock(ListEstablishmentEmployeeController.class);
        ListEstablishmentEmployee listEstablishmentEmployeeService = Mockito.mock(ListEstablishmentEmployee.class);
        ListEstablishmentEmployeeRoute listEstablishmentEmployeeRoute = new ListEstablishmentEmployeeRoute(listEstablishmentEmployeeService);

        List<EstablishmentEmployee> establishmentEmployees = new ArrayList<>();
        establishmentEmployees.add(new EstablishmentEmployee(BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(1), new Timestamp(123), new Timestamp(123)));
        establishmentEmployees.add(new EstablishmentEmployee(BigInteger.valueOf(2), BigInteger.valueOf(2), BigInteger.valueOf(2), new Timestamp(123), new Timestamp(123)));

        List<EstablishmentEmployeeDTO> establishmentEmployeeDTOS = new ArrayList<>();

        establishmentEmployeeDTOS.add(new EstablishmentEmployeeDTO(BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(1), new Timestamp(123), new Timestamp(123)));
        establishmentEmployeeDTOS.add(new EstablishmentEmployeeDTO(BigInteger.valueOf(2), BigInteger.valueOf(2), BigInteger.valueOf(2), new Timestamp(123), new Timestamp(123)));

        Page<EstablishmentEmployeeDTO> establishmentEmployeePage = new PageImpl<>(establishmentEmployeeDTOS, PageRequest.of(0, 2), establishmentEmployeeDTOS.size());

        doReturn(establishmentEmployees).when(listEstablishmentEmployeeController).perform();
        doReturn(establishmentEmployees).when(listEstablishmentEmployeeService).perform();

        Page<EstablishmentEmployeeDTO> result = listEstablishmentEmployeeRoute.perform(0, 2);

        assertThat(result).isNotNull();
        assertThat(result.getContent()).hasSize(2);
        assertThat(result.getContent().get(0).getId()).isEqualTo(1L);
        assertThat(result.getContent().get(1).getId()).isEqualTo(2L);
    }
}

