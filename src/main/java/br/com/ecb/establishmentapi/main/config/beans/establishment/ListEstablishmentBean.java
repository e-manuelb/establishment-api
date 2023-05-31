package br.com.ecb.establishmentapi.main.config.beans.establishment;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentRepository;
import br.com.ecb.establishmentapi.data.services.establishment.ListEstablishmentService;
import br.com.ecb.establishmentapi.domain.features.establishment.ListEstablishment;
import br.com.ecb.establishmentapi.domain.features.establishment.address.FindAddressByEstablishmentId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListEstablishmentBean {
    EstablishmentRepository establishmentRepository;

    FindAddressByEstablishmentId findAddressByEstablishmentId;

    public ListEstablishmentBean(EstablishmentRepository establishmentRepository, FindAddressByEstablishmentId findAddressByEstablishmentId) {
        this.establishmentRepository = establishmentRepository;
        this.findAddressByEstablishmentId = findAddressByEstablishmentId;
    }

    @Bean
    public ListEstablishment listEstablishment() {
        return new ListEstablishmentService(establishmentRepository, findAddressByEstablishmentId);
    }
}
