package br.com.ecb.establishmentapi.data.services.establishment;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.ListEstablishment;
import br.com.ecb.establishmentapi.domain.features.establishment.address.FindAddressByEstablishmentId;
import br.com.ecb.establishmentapi.domain.models.Establishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListEstablishmentService implements ListEstablishment {
    private EstablishmentRepository establishmentRepository;

    private FindAddressByEstablishmentId findAddressByEstablishmentId;

    public ListEstablishmentService(EstablishmentRepository establishmentRepository, FindAddressByEstablishmentId findAddressByEstablishmentId) {
        this.establishmentRepository = establishmentRepository;
        this.findAddressByEstablishmentId = findAddressByEstablishmentId;
    }

    public List<EstablishmentWithAddress> perform() {
        List<Establishment> establishments = this.establishmentRepository.findAll();

        List<EstablishmentWithAddress> establishmentWithAddresses = new ArrayList<>();

        establishments.forEach(establishment -> {
            EstablishmentAddress address = findAddressByEstablishmentId.perform(establishment.getId());

            establishmentWithAddresses.add(new EstablishmentWithAddress(establishment, address));
        });

        return establishmentWithAddresses;
    }
}
