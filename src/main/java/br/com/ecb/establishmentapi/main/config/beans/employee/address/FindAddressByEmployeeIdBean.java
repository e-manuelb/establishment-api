package br.com.ecb.establishmentapi.main.config.beans.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.data.services.employee.address.FindAddressByEmployeeIdService;
import br.com.ecb.establishmentapi.domain.features.employee.address.FindAddressByEmployeeId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAddressByEmployeeIdBean {
    EmployeeAddressRepository employeeAddressRepository;

    public FindAddressByEmployeeIdBean(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    @Bean
    public FindAddressByEmployeeId findAddressByEmployeeId() {
        return new FindAddressByEmployeeIdService(employeeAddressRepository);
    }
}
