package br.com.ecb.establishmentapi.main.config.beans.employee;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeRepository;
import br.com.ecb.establishmentapi.data.services.employee.ListEmployeeService;
import br.com.ecb.establishmentapi.domain.features.employee.ListEmployee;
import br.com.ecb.establishmentapi.domain.features.employee.address.FindAddressByEmployeeId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListEmployeeBean {

    EmployeeRepository employeeRepository;

    FindAddressByEmployeeId findAddressByEmployeeId;

    public ListEmployeeBean(EmployeeRepository employeeRepository, FindAddressByEmployeeId findAddressByEmployeeId) {
        this.employeeRepository = employeeRepository;
        this.findAddressByEmployeeId = findAddressByEmployeeId;
    }

    @Bean
    public ListEmployee listEmployee() {
        return new ListEmployeeService(employeeRepository, findAddressByEmployeeId);
    }
}
