package br.com.ecb.establishmentapi.main.config.beans.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.data.services.employee.address.ListEmployeeAddressService;
import br.com.ecb.establishmentapi.domain.features.employee.address.ListEmployeeAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListEmployeeAddressBean {
    EmployeeAddressRepository employeeAddressRepository;

    public ListEmployeeAddressBean(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    @Bean
    public ListEmployeeAddress listEmployeeAddress() {
        return new ListEmployeeAddressService(employeeAddressRepository);
    }
}
