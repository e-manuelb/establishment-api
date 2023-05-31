package br.com.ecb.establishmentapi.data.services.establishment;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.DeleteEstablishmentById;
import br.com.ecb.establishmentapi.domain.features.establishment.address.DeleteAddressByEstablishmentId;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
public class DeleteEstablishmentByIdService implements DeleteEstablishmentById {
    private EstablishmentRepository establishmentRepository;
    private DeleteAddressByEstablishmentId deleteAddressByEstablishmentIdService;

    public DeleteEstablishmentByIdService(EstablishmentRepository establishmentRepository, DeleteAddressByEstablishmentId deleteAddressByEstablishmentIdService) {
        this.establishmentRepository = establishmentRepository;
        this.deleteAddressByEstablishmentIdService = deleteAddressByEstablishmentIdService;
    }

    public void perform(BigInteger id) {
        this.deleteAddressByEstablishmentIdService.perform(id);
        this.establishmentRepository.deleteById(id);
    }
}
