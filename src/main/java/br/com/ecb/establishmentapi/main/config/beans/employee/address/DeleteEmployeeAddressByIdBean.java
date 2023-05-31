package br.com.ecb.establishmentapi.main.config.beans.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.data.services.employee.address.DeleteEmployeeAddressByIdService;
import br.com.ecb.establishmentapi.domain.features.employee.address.DeleteEmployeeAddressById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteEmployeeAddressByIdBean {
    EmployeeAddressRepository employeeAddressRepository;

    public DeleteEmployeeAddressByIdBean(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    @Bean
    public DeleteEmployeeAddressById deleteEmployeeAddressById() {
        return new DeleteEmployeeAddressByIdService(employeeAddressRepository);
    }
}
