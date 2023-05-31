package br.com.ecb.establishmentapi.main.config.beans.employee;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeRepository;
import br.com.ecb.establishmentapi.data.services.employee.DeleteEmployeeByIdService;
import br.com.ecb.establishmentapi.domain.features.employee.DeleteEmployeeById;
import br.com.ecb.establishmentapi.domain.features.employee.address.DeleteAddressByEmployeeId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteEmployeeByIdBean {
    EmployeeRepository employeeRepository;
    DeleteAddressByEmployeeId deleteAddressByEmployeeId;

    public DeleteEmployeeByIdBean(EmployeeRepository employeeRepository, DeleteAddressByEmployeeId deleteAddressByEmployeeId) {
        this.employeeRepository = employeeRepository;
        this.deleteAddressByEmployeeId = deleteAddressByEmployeeId;
    }

    @Bean
    DeleteEmployeeById deleteEmployeeById() {
        return new DeleteEmployeeByIdService(employeeRepository, deleteAddressByEmployeeId);
    }
}
