package br.com.ecb.establishmentapi.main.config.beans.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.data.services.employee.address.DeleteAddressByEmployeeIdService;
import br.com.ecb.establishmentapi.domain.features.employee.address.DeleteAddressByEmployeeId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteAddressByEmployeeIdBean {
    EmployeeAddressRepository employeeAddressRepository;

    public DeleteAddressByEmployeeIdBean(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    @Bean
    public DeleteAddressByEmployeeId deleteAddressByEmployeeId() {
        return new DeleteAddressByEmployeeIdService(employeeAddressRepository);
    }
}
