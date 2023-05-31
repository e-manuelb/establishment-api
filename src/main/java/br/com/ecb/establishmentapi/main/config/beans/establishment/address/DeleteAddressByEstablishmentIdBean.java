package br.com.ecb.establishmentapi.main.config.beans.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.data.services.establishment.address.DeleteAddressByEstablishmentIdService;
import br.com.ecb.establishmentapi.domain.features.establishment.address.DeleteAddressByEstablishmentId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteAddressByEstablishmentIdBean {
    EstablishmentAddressRepository establishmentAddressRepository;

    public DeleteAddressByEstablishmentIdBean(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    @Bean
    public DeleteAddressByEstablishmentId deleteAddressByEstablishmentId() {
        return new DeleteAddressByEstablishmentIdService(establishmentAddressRepository);
    }
}
