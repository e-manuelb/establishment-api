package br.com.ecb.establishmentapi.main.config.beans.employee;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeRepository;
import br.com.ecb.establishmentapi.data.services.employee.FindEmployeeByIdService;
import br.com.ecb.establishmentapi.domain.features.employee.FindEmployeeById;
import br.com.ecb.establishmentapi.domain.features.employee.address.FindAddressByEmployeeId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindEmployeeByIdBean {
    EmployeeRepository employeeRepository;
    FindAddressByEmployeeId findAddressByEmployeeId;

    public FindEmployeeByIdBean(EmployeeRepository employeeRepository, FindAddressByEmployeeId findAddressByEmployeeId) {
        this.employeeRepository = employeeRepository;
        this.findAddressByEmployeeId = findAddressByEmployeeId;
    }

    @Bean
    FindEmployeeById findEmployeeById() {
        return new FindEmployeeByIdService(employeeRepository, findAddressByEmployeeId);
    }
}
