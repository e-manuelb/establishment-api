package br.com.ecb.establishmentapi.main.config.beans.establishment;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentRepository;
import br.com.ecb.establishmentapi.data.services.establishment.DeleteEstablishmentByIdService;
import br.com.ecb.establishmentapi.domain.features.establishment.DeleteEstablishmentById;
import br.com.ecb.establishmentapi.domain.features.establishment.address.DeleteAddressByEstablishmentId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteEstablishmentByIdBean {
    EstablishmentRepository establishmentRepository;

    DeleteAddressByEstablishmentId deleteAddressByEstablishmentId;

    public DeleteEstablishmentByIdBean(EstablishmentRepository establishmentRepository, DeleteAddressByEstablishmentId deleteAddressByEstablishmentId) {
        this.establishmentRepository = establishmentRepository;
        this.deleteAddressByEstablishmentId = deleteAddressByEstablishmentId;
    }

    @Bean
    public DeleteEstablishmentById deleteEstablishmentById() {
        return new DeleteEstablishmentByIdService(establishmentRepository, deleteAddressByEstablishmentId);
    }
}
