package br.com.ecb.establishmentapi.main.config.beans.establishment;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentRepository;
import br.com.ecb.establishmentapi.data.services.establishment.FindEstablishmentByIdService;
import br.com.ecb.establishmentapi.domain.features.establishment.FindEstablishmentById;
import br.com.ecb.establishmentapi.domain.features.establishment.address.FindAddressByEstablishmentId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindEstablishmentByIdBean {
    EstablishmentRepository establishmentRepository;

    FindAddressByEstablishmentId findAddressByEstablishmentId;

    public FindEstablishmentByIdBean(EstablishmentRepository establishmentRepository, FindAddressByEstablishmentId findAddressByEstablishmentId) {
        this.establishmentRepository = establishmentRepository;
        this.findAddressByEstablishmentId = findAddressByEstablishmentId;
    }

    @Bean
    public FindEstablishmentById findEstablishmentById() {
        return new FindEstablishmentByIdService(establishmentRepository, findAddressByEstablishmentId);
    }
}
