package br.com.ecb.establishmentapi.data.services.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.address.FindEstablishmentAddressById;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class FindEstablishmentAddressByIdService implements FindEstablishmentAddressById {
    private EstablishmentAddressRepository establishmentAddressRepository;

    public FindEstablishmentAddressByIdService(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    public Optional<EstablishmentAddress> perform(BigInteger id) {
        return this.establishmentAddressRepository.findById(id);
    }
}
