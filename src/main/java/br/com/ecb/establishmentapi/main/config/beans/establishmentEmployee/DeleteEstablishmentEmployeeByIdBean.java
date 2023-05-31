package br.com.ecb.establishmentapi.main.config.beans.establishmentEmployee;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentEmployeeRepository;
import br.com.ecb.establishmentapi.data.services.establishmentEmployee.DeleteEstablishmentEmployeeByIdService;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.DeleteEstablishmentEmployeeById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteEstablishmentEmployeeByIdBean {
    EstablishmentEmployeeRepository establishmentEmployeeRepository;

    public DeleteEstablishmentEmployeeByIdBean(EstablishmentEmployeeRepository establishmentEmployeeRepository) {
        this.establishmentEmployeeRepository = establishmentEmployeeRepository;
    }

    @Bean
    public DeleteEstablishmentEmployeeById deleteEstablishmentEmployeeByIdById() {
        return new DeleteEstablishmentEmployeeByIdService(establishmentEmployeeRepository);
    }
}
