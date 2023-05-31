package br.com.ecb.establishmentapi.domain.features.establishment.address;

import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;

public interface UpdateEstablishmentAddress {
    EstablishmentAddress perform(EstablishmentAddress establishmentAddress) throws Exception;
}
