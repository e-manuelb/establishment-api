package br.com.ecb.establishmentapi.data.services.establishment;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.FindEstablishmentById;
import br.com.ecb.establishmentapi.domain.features.establishment.address.FindAddressByEstablishmentId;
import br.com.ecb.establishmentapi.domain.models.*;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class FindEstablishmentByIdService implements FindEstablishmentById {
    private EstablishmentRepository establishmentRepository;

    private FindAddressByEstablishmentId findAddressByEstablishmentIdService;

    public FindEstablishmentByIdService(EstablishmentRepository establishmentRepository, FindAddressByEstablishmentId findAddressByEstablishmentIdService) {
        this.establishmentRepository = establishmentRepository;
        this.findAddressByEstablishmentIdService = findAddressByEstablishmentIdService;
    }

    public EstablishmentWithAddress perform(BigInteger id) throws Exception {
        Establishment establishment = this.establishmentRepository.findById(id).get();

        if (establishment == null) {
            throw new Exception("Establishment with ID #" + id + " not found.");
        }

        EstablishmentAddress address = findAddressByEstablishmentIdService.perform(establishment.getId());

        return new EstablishmentWithAddress(
                new Establishment()
                        .setId(establishment.getId())
                        .setName(establishment.getName())
                        .setPhone(establishment.getPhone()),
                new EstablishmentAddress()
                        .setId(address.getId())
                        .setAddress(address.getAddress())
                        .setNumber(address.getNumber())
                        .setComplement(address.getComplement())
                        .setNeighborhood(address.getNeighborhood())
                        .setCep(address.getCep())
                        .setCity(address.getCity())
                        .setState(address.getState())
                        .setEstablishmentId(address.getEstablishmentId())
        );
    }
}
