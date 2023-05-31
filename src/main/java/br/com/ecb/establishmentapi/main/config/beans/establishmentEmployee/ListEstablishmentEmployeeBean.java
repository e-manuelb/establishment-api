package br.com.ecb.establishmentapi.main.config.beans.establishmentEmployee;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentEmployeeRepository;
import br.com.ecb.establishmentapi.data.services.establishmentEmployee.ListEstablishmentEmployeeService;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.ListEstablishmentEmployee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListEstablishmentEmployeeBean {
    EstablishmentEmployeeRepository establishmentEmployeeRepository;

    public ListEstablishmentEmployeeBean(EstablishmentEmployeeRepository establishmentEmployeeRepository) {
        this.establishmentEmployeeRepository = establishmentEmployeeRepository;
    }

    @Bean
    public ListEstablishmentEmployee listEstablishmentEmployee() {
        return new ListEstablishmentEmployeeService(establishmentEmployeeRepository);
    }
}
