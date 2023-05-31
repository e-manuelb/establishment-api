package br.com.ecb.establishmentapi.main.config.beans.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.data.services.employee.address.FindEmployeeAddressByIdService;
import br.com.ecb.establishmentapi.domain.features.employee.address.FindEmployeeAddressById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindEmployeeAddressByIdBean {
    EmployeeAddressRepository employeeAddressRepository;

    public FindEmployeeAddressByIdBean(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    @Bean
    public FindEmployeeAddressById findEmployeeAddressById() {
        return new FindEmployeeAddressByIdService(employeeAddressRepository);
    }
}
