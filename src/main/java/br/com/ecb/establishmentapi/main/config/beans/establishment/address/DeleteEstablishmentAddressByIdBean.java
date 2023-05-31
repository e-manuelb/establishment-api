package br.com.ecb.establishmentapi.main.config.beans.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.data.services.establishment.address.DeleteEstablishmentAddressByIdService;
import br.com.ecb.establishmentapi.domain.features.establishment.address.DeleteEstablishmentAddressById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteEstablishmentAddressByIdBean {
    EstablishmentAddressRepository establishmentAddressRepository;

    public DeleteEstablishmentAddressByIdBean(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    @Bean
    public DeleteEstablishmentAddressById deleteEstablishmentAddressById() {
        return new DeleteEstablishmentAddressByIdService(establishmentAddressRepository);
    }
}
