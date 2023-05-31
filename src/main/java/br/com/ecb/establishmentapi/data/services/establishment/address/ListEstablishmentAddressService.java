package br.com.ecb.establishmentapi.data.services.establishment.address;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentAddressRepository;
import br.com.ecb.establishmentapi.domain.features.establishment.address.ListEstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListEstablishmentAddressService implements ListEstablishmentAddress {
    private EstablishmentAddressRepository establishmentAddressRepository;

    public ListEstablishmentAddressService(EstablishmentAddressRepository establishmentAddressRepository) {
        this.establishmentAddressRepository = establishmentAddressRepository;
    }

    public List<EstablishmentAddress> perform() {
        return  this.establishmentAddressRepository.findAll();
    }
}
