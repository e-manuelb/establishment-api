package br.com.ecb.establishmentapi.data.services.establishment;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.UpdateEstablishment;
import br.com.ecb.establishmentapi.domain.features.establishment.address.UpdateEstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.Establishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateEstablishmentService implements UpdateEstablishment {
    private EstablishmentRepository establishmentRepository;

    private UpdateEstablishmentAddress updateEstablishmentAddress;

    public UpdateEstablishmentService(EstablishmentRepository establishmentRepository, UpdateEstablishmentAddress updateEstablishmentAddress) {
        this.establishmentRepository = establishmentRepository;
        this.updateEstablishmentAddress = updateEstablishmentAddress;
    }

    public EstablishmentWithAddress perform(EstablishmentWithAddress establishmentWithAddress) throws Exception {
        Optional<Establishment> establishmentToUpdate = this.establishmentRepository.findById(establishmentWithAddress.getEstablishment().getId());

        if (establishmentToUpdate == null) {
            throw new Exception("Establishment with ID #" + establishmentWithAddress.getEstablishment().getId() + " not found.");
        }

        Establishment establishmentUpdated = this.establishmentRepository.save(establishmentWithAddress.getEstablishment());
        EstablishmentAddress establishmentAddressUpdated = this.updateEstablishmentAddress.perform(establishmentWithAddress.getAddress());

        return new EstablishmentWithAddress(establishmentUpdated, establishmentAddressUpdated);
    }
}
