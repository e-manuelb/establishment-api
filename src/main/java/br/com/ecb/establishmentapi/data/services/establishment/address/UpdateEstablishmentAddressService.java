package br.com.ecb.establishmentapi.data.services.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.address.UpdateEstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateEstablishmentAddressService implements UpdateEstablishmentAddress {
    private EstablishmentAddressRepository establishmentAddressRepository;

    public UpdateEstablishmentAddressService(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    public EstablishmentAddress perform(EstablishmentAddress establishmentAddress) throws Exception {
        Optional<EstablishmentAddress> establishmentAddressToUpdate = this.establishmentAddressRepository.findById(establishmentAddress.getId());

        if (establishmentAddressToUpdate == null) {
            throw new Exception("Establishment Address with ID #" + establishmentAddress.getId() + " not found.");
        }

        return this.establishmentAddressRepository.save(establishmentAddress);
    }
}
