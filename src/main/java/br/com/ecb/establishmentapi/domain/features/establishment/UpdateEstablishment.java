package br.com.ecb.establishmentapi.domain.features.establishment;

import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;

public interface UpdateEstablishment {
    EstablishmentWithAddress perform(EstablishmentWithAddress establishmentWithAddress) throws Exception;
}
