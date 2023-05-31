package br.com.ecb.establishmentapi.data.services.establishment;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.SaveEstablishment;
import br.com.ecb.establishmentapi.domain.features.establishment.address.SaveEstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.Establishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import org.springframework.stereotype.Service;

@Service
public class SaveEstablishmentService implements SaveEstablishment {
    private EstablishmentRepository establishmentRepository;

    private SaveEstablishmentAddress saveEstablishmentAddressService;

    public SaveEstablishmentService(EstablishmentRepository establishmentRepository, SaveEstablishmentAddress saveEstablishmentAddressService) {
        this.establishmentRepository = establishmentRepository;
        this.saveEstablishmentAddressService = saveEstablishmentAddressService;
    }

    public EstablishmentWithAddress perform(EstablishmentWithAddress establishmentWithAddress) {
        Establishment establishment = this.establishmentRepository.save(
                new Establishment()
                        .setName(establishmentWithAddress.getEstablishment().getName())
                        .setPhone(establishmentWithAddress.getEstablishment().getPhone())
        );

        EstablishmentAddress establishmentAddress = saveEstablishmentAddressService.perform(
                new EstablishmentAddress()
                        .setAddress(establishmentWithAddress.getAddress().getAddress())
                        .setNumber(establishmentWithAddress.getAddress().getNumber())
                        .setComplement(establishmentWithAddress.getAddress().getComplement())
                        .setNeighborhood(establishmentWithAddress.getAddress().getNeighborhood())
                        .setCep(establishmentWithAddress.getAddress().getCep())
                        .setCity(establishmentWithAddress.getAddress().getCity())
                        .setState(establishmentWithAddress.getAddress().getState())
                        .setEstablishmentId(establishment.getId())
        );

        return new EstablishmentWithAddress(establishment, establishmentAddress);
    }
}
