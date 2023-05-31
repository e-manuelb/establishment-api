package br.com.ecb.establishmentapi.data.services.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.address.SaveEstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import org.springframework.stereotype.Service;

@Service
public class SaveEstablishmentAddressService implements SaveEstablishmentAddress {
    private EstablishmentAddressRepository establishmentAddressRepository;

    public SaveEstablishmentAddressService(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    public EstablishmentAddress perform(EstablishmentAddress establishmentAddress) {
        return this.establishmentAddressRepository.save(establishmentAddress);
    }
}
