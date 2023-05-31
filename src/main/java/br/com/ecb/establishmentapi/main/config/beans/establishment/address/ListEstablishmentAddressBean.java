package br.com.ecb.establishmentapi.main.config.beans.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.data.services.establishment.address.ListEstablishmentAddressService;
import br.com.ecb.establishmentapi.domain.features.establishment.address.ListEstablishmentAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListEstablishmentAddressBean {
    EstablishmentAddressRepository establishmentAddressRepository;

    public ListEstablishmentAddressBean(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    @Bean
    public ListEstablishmentAddress listEstablishmentAddress() {
        return new ListEstablishmentAddressService(establishmentAddressRepository);
    }
}
