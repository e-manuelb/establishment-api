package br.com.ecb.establishmentapi.main.config.beans.establishment;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentRepository;
import br.com.ecb.establishmentapi.data.services.establishment.SaveEstablishmentService;
import br.com.ecb.establishmentapi.domain.features.establishment.SaveEstablishment;
import br.com.ecb.establishmentapi.domain.features.establishment.address.SaveEstablishmentAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveEstablishmentBean {
    EstablishmentRepository establishmentRepository;
    SaveEstablishmentAddress saveEstablishmentAddressService;

    public SaveEstablishmentBean(EstablishmentRepository establishmentRepository, SaveEstablishmentAddress saveEstablishmentAddressService) {
        this.establishmentRepository = establishmentRepository;
        this.saveEstablishmentAddressService = saveEstablishmentAddressService;
    }

    @Bean
    public SaveEstablishment saveEstablishment() {
        return new SaveEstablishmentService(establishmentRepository, saveEstablishmentAddressService);
    }
}
