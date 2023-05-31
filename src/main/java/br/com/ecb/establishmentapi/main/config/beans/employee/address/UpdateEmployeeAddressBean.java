package br.com.ecb.establishmentapi.main.config.beans.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.data.services.employee.address.UpdateEmployeeAddressService;
import br.com.ecb.establishmentapi.domain.features.employee.address.UpdateEmployeeAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateEmployeeAddressBean {
    EmployeeAddressRepository employeeAddressRepository;

    public UpdateEmployeeAddressBean(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    @Bean
    public UpdateEmployeeAddress updateEmployeeAddress() {
        return new UpdateEmployeeAddressService(employeeAddressRepository);
    }
}
