package br.com.ecb.establishmentapi.main.config.beans.establishmentEmployee;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentEmployeeRepository;
import br.com.ecb.establishmentapi.data.services.establishmentEmployee.SaveEstablishmentEmployeeService;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.SaveEstablishmentEmployee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveEstablishmentEmployeeBean {
    EstablishmentEmployeeRepository establishmentEmployeeRepository;

    public SaveEstablishmentEmployeeBean(EstablishmentEmployeeRepository establishmentEmployeeRepository) {
        this.establishmentEmployeeRepository = establishmentEmployeeRepository;
    }

    @Bean
    public SaveEstablishmentEmployee saveEstablishmentEmployee() {
        return new SaveEstablishmentEmployeeService(establishmentEmployeeRepository);
    }
}
