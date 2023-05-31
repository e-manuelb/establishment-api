package br.com.ecb.establishmentapi.data.services.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.address.FindAddressByEstablishmentId;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class FindAddressByEstablishmentIdService implements FindAddressByEstablishmentId {
    private EstablishmentAddressRepository establishmentAddressRepository;

    public FindAddressByEstablishmentIdService(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    public EstablishmentAddress perform(BigInteger id) {
        return this.establishmentAddressRepository.findByEstablishmentId(id);
    }
}
