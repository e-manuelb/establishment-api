package br.com.ecb.establishmentapi.main.routes.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.UpdateEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.UpdateEmployee;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import br.com.ecb.establishmentapi.shared.dtos.request.employee.UpdateEmployeeDTO;
import br.com.ecb.establishmentapi.shared.dtos.response.EmployeeWithAddressDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

public class UpdateEmployeeRouteTest {

    @Test
    public void testPerform() throws Exception {
        UpdateEmployeeController updateEmployeeController = Mockito.mock(UpdateEmployeeController.class);
        UpdateEmployee updateEmployeeService = Mockito.mock(UpdateEmployee.class);
        UpdateEmployeeRoute updateEmployeeRoute = new UpdateEmployeeRoute(updateEmployeeService);

        UpdateEmployeeDTO updateEmployeeDTO = new UpdateEmployeeDTO();
        updateEmployeeDTO.setEmployeeId(BigInteger.valueOf(1));
        updateEmployeeDTO.setName("John Doe");
        updateEmployeeDTO.setPhotoUrl("photo.jpg");
        updateEmployeeDTO.setPhone("123456789");
        updateEmployeeDTO.setRole("Manager");

        EmployeeWithAddress employeeWithAddress = updateEmployeeDTO.toEmployeeWithAddress();

        doReturn(employeeWithAddress).when(updateEmployeeController).perform(Mockito.any(EmployeeWithAddress.class));
        doReturn(employeeWithAddress).when(updateEmployeeService).perform(Mockito.any(EmployeeWithAddress.class));

        EmployeeWithAddressDTO result = updateEmployeeRoute.perform(updateEmployeeDTO);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(employeeWithAddress.getEmployee().getId());
        assertThat(result.getName()).isEqualTo(employeeWithAddress.getEmployee().getName());
        assertThat(result.getPhotoUrl()).isEqualTo(employeeWithAddress.getEmployee().getPhotoUrl());
        assertThat(result.getPhone()).isEqualTo(employeeWithAddress.getEmployee().getPhone());
        assertThat(result.getRole()).isEqualTo(employeeWithAddress.getEmployee().getRole());
        assertThat(result.getAddress()).isEqualTo(employeeWithAddress.getAddress());
        assertThat(result.getCreatedAt()).isEqualTo(employeeWithAddress.getEmployee().getCreatedAt());
        assertThat(result.getUpdatedAt()).isEqualTo(employeeWithAddress.getEmployee().getUpdatedAt());
    }
}

