package br.com.ecb.establishmentapi.main.config.beans.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.data.services.establishment.address.FindAddressByEstablishmentIdService;
import br.com.ecb.establishmentapi.domain.features.establishment.address.FindAddressByEstablishmentId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAddressByEstablishmentIdBean {
    EstablishmentAddressRepository establishmentAddressRepository;

    public FindAddressByEstablishmentIdBean(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    @Bean
    public FindAddressByEstablishmentId findAddressByEstablishmentId() {
        return new FindAddressByEstablishmentIdService(establishmentAddressRepository);
    }
}
