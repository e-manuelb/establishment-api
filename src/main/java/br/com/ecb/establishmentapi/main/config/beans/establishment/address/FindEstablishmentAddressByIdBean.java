package br.com.ecb.establishmentapi.main.config.beans.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.data.services.establishment.address.FindEstablishmentAddressByIdService;
import br.com.ecb.establishmentapi.domain.features.establishment.address.FindEstablishmentAddressById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindEstablishmentAddressByIdBean {
    EstablishmentAddressRepository establishmentAddressRepository;

    public FindEstablishmentAddressByIdBean(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    @Bean
    public FindEstablishmentAddressById findEstablishmentAddressById() {
        return new FindEstablishmentAddressByIdService(establishmentAddressRepository);
    }
}
