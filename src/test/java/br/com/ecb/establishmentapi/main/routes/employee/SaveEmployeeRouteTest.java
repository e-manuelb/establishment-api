package br.com.ecb.establishmentapi.main.routes.employee;

import br.com.ecb.establishmentapi.application.controllers.employee.SaveEmployeeController;
import br.com.ecb.establishmentapi.domain.features.employee.SaveEmployee;
import br.com.ecb.establishmentapi.domain.models.Employee;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import br.com.ecb.establishmentapi.shared.dtos.request.employee.SaveEmployeeDTO;
import br.com.ecb.establishmentapi.shared.dtos.response.EmployeeWithAddressDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

public class SaveEmployeeRouteTest {
    @Test
    public void testPerform() {
        SaveEmployeeController saveEmployeeController = Mockito.mock(SaveEmployeeController.class);
        SaveEmployee saveEmployeeService = Mockito.mock(SaveEmployee.class);
        SaveEmployeeRoute saveEmployeeRoute = new SaveEmployeeRoute(saveEmployeeService);

        SaveEmployeeDTO saveEmployeeDTO = new SaveEmployeeDTO();

        saveEmployeeDTO.setName("John Doe");
        saveEmployeeDTO.setPhotoUrl("photo.jpg");
        saveEmployeeDTO.setPhone("123456789");
        saveEmployeeDTO.setRole("Manager");
        saveEmployeeDTO.setAddress("123 Main St");
        saveEmployeeDTO.setNumber("1");
        saveEmployeeDTO.setComplement("Apt 2B");
        saveEmployeeDTO.setNeighborhood("Downtown");
        saveEmployeeDTO.setCep("61801780");
        saveEmployeeDTO.setCity("City");
        saveEmployeeDTO.setState("State");

        EmployeeWithAddress employeeWithAddress =
                new EmployeeWithAddress(
                        new Employee()
                                .setName(saveEmployeeDTO.getName())
                                .setPhone(saveEmployeeDTO.getPhone())
                                .setPhotoUrl(saveEmployeeDTO.getPhotoUrl())
                                .setRole(saveEmployeeDTO.getRole()),
                        new EmployeeAddress()
                                .setAddress(saveEmployeeDTO.getAddress())
                                .setNumber(saveEmployeeDTO.getNumber())
                                .setComplement(saveEmployeeDTO.getComplement())
                                .setNeighborhood(saveEmployeeDTO.getNeighborhood())
                                .setCep(saveEmployeeDTO.getCep())
                                .setCity(saveEmployeeDTO.getCity())
                                .setState(saveEmployeeDTO.getState()));

        doReturn(employeeWithAddress).when(saveEmployeeService).perform(Mockito.any(EmployeeWithAddress.class));
        doReturn(employeeWithAddress).when(saveEmployeeController).perform(Mockito.any(EmployeeWithAddress.class));

        EmployeeWithAddressDTO result = saveEmployeeRoute.perform(saveEmployeeDTO);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(employeeWithAddress.getEmployee().getId());
        assertThat(result.getName()).isEqualTo(employeeWithAddress.getEmployee().getName());
        assertThat(result.getPhotoUrl()).isEqualTo(employeeWithAddress.getEmployee().getPhotoUrl());
        assertThat(result.getPhone()).isEqualTo(employeeWithAddress.getEmployee().getPhone());
        assertThat(result.getRole()).isEqualTo(employeeWithAddress.getEmployee().getRole());
        assertThat(result.getAddress()).isNotNull();
        assertThat(result.getAddress().getAddress()).isEqualTo(employeeWithAddress.getAddress().getAddress());
        assertThat(result.getAddress().getNumber()).isEqualTo(employeeWithAddress.getAddress().getNumber());
        assertThat(result.getAddress().getComplement()).isEqualTo(employeeWithAddress.getAddress().getComplement());
        assertThat(result.getAddress().getNeighborhood()).isEqualTo(employeeWithAddress.getAddress().getNeighborhood());
        assertThat(result.getAddress().getCep()).isEqualTo(employeeWithAddress.getAddress().getCep());
        assertThat(result.getAddress().getCity()).isEqualTo(employeeWithAddress.getAddress().getCity());
        assertThat(result.getAddress().getState()).isEqualTo(employeeWithAddress.getAddress().getState());
        assertThat(result.getCreatedAt()).isEqualTo(employeeWithAddress.getAddress().getCreatedAt());
        assertThat(result.getUpdatedAt()).isEqualTo(employeeWithAddress.getAddress().getUpdatedAt());
    }
}
