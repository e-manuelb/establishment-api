package br.com.ecb.establishmentapi.main.config.beans.establishment;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentRepository;
import br.com.ecb.establishmentapi.data.services.establishment.UpdateEstablishmentService;
import br.com.ecb.establishmentapi.domain.features.establishment.UpdateEstablishment;
import br.com.ecb.establishmentapi.domain.features.establishment.address.UpdateEstablishmentAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateEstablishmentBean {
    EstablishmentRepository establishmentRepository;
    UpdateEstablishmentAddress updateEstablishmentAddress;

    public UpdateEstablishmentBean(EstablishmentRepository establishmentRepository, UpdateEstablishmentAddress updateEstablishmentAddress) {
        this.establishmentRepository = establishmentRepository;
        this.updateEstablishmentAddress = updateEstablishmentAddress;
    }

    @Bean
    public UpdateEstablishment updateEstablishment() {
        return new UpdateEstablishmentService(establishmentRepository, updateEstablishmentAddress);
    }
}
