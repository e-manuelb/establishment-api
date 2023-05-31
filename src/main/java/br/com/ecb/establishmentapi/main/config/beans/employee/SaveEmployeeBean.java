package br.com.ecb.establishmentapi.main.config.beans.employee;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeRepository;
import br.com.ecb.establishmentapi.data.services.employee.SaveEmployeeService;
import br.com.ecb.establishmentapi.domain.features.employee.SaveEmployee;
import br.com.ecb.establishmentapi.domain.features.employee.address.SaveEmployeeAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveEmployeeBean {
    EmployeeRepository employeeRepository;
    SaveEmployeeAddress saveEmployeeAddress;

    public SaveEmployeeBean(EmployeeRepository employeeRepository, SaveEmployeeAddress saveEmployeeAddress) {
        this.employeeRepository = employeeRepository;
        this.saveEmployeeAddress = saveEmployeeAddress;
    }

    @Bean
    public SaveEmployee saveEmployee() {
        return new SaveEmployeeService(employeeRepository, saveEmployeeAddress);
    }
}
