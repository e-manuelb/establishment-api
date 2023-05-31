package br.com.ecb.establishmentapi.main.config.beans.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.data.services.establishment.address.SaveEstablishmentAddressService;
import br.com.ecb.establishmentapi.domain.features.establishment.address.SaveEstablishmentAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveEstablishmentAddressBean {
    EstablishmentAddressRepository establishmentAddressRepository;

    public SaveEstablishmentAddressBean(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    @Bean
    public SaveEstablishmentAddress saveEstablishmentAddress() {
        return new SaveEstablishmentAddressService(establishmentAddressRepository);
    }
}
