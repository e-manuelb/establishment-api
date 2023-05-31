package br.com.ecb.establishmentapi.main.config.beans.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.data.services.employee.address.SaveEmployeeAddressService;
import br.com.ecb.establishmentapi.domain.features.employee.address.SaveEmployeeAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveEmployeeAddressBean {
    EmployeeAddressRepository employeeAddressRepository;

    public SaveEmployeeAddressBean(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    @Bean
    public SaveEmployeeAddress saveEmployeeAddress() {
        return new SaveEmployeeAddressService(employeeAddressRepository);
    }
}
