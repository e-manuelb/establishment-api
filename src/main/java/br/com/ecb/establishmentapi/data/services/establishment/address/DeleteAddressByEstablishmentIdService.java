package br.com.ecb.establishmentapi.data.services.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.address.DeleteAddressByEstablishmentId;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
public class DeleteAddressByEstablishmentIdService implements DeleteAddressByEstablishmentId {
    private EstablishmentAddressRepository establishmentAddressRepository;

    public DeleteAddressByEstablishmentIdService(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    public void perform(BigInteger id) {
        this.establishmentAddressRepository.deleteByEstablishmentId(id);
    }
}
