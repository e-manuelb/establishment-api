package br.com.ecb.establishmentapi.data.services.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.address.DeleteEstablishmentAddressById;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
public class DeleteEstablishmentAddressByIdService implements DeleteEstablishmentAddressById {
    private EstablishmentAddressRepository establishmentAddressRepository;

    public DeleteEstablishmentAddressByIdService(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    public void perform(BigInteger id) {
        this.establishmentAddressRepository.deleteById(id);
    }
}
