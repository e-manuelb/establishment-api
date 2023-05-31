package br.com.ecb.establishmentapi.main.config.beans.employee;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeRepository;
import br.com.ecb.establishmentapi.data.services.employee.UpdateEmployeeService;
import br.com.ecb.establishmentapi.domain.features.employee.UpdateEmployee;
import br.com.ecb.establishmentapi.domain.features.employee.address.UpdateEmployeeAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateEmployeeBean {
    EmployeeRepository employeeRepository;

    UpdateEmployeeAddress updateEmployeeAddressService;

    public UpdateEmployeeBean(EmployeeRepository employeeRepository, UpdateEmployeeAddress updateEmployeeAddressService) {
        this.employeeRepository = employeeRepository;
        this.updateEmployeeAddressService = updateEmployeeAddressService;
    }

    @Bean
    UpdateEmployee updateEmployee() {
        return new UpdateEmployeeService(employeeRepository, updateEmployeeAddressService);
    }
}
