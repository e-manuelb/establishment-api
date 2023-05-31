package br.com.ecb.establishmentapi.main.config.beans.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.data.services.establishment.address.UpdateEstablishmentAddressService;
import br.com.ecb.establishmentapi.domain.features.establishment.address.UpdateEstablishmentAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateEstablishmentAddressBean {
    EstablishmentAddressRepository establishmentAddressRepository;

    public UpdateEstablishmentAddressBean(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    @Bean
    public UpdateEstablishmentAddress updateEstablishmentAddress() {
        return new UpdateEstablishmentAddressService(establishmentAddressRepository);
    }
}
