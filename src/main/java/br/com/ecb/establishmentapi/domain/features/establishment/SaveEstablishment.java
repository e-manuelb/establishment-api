package br.com.ecb.establishmentapi.domain.features.establishment;

import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;

public interface SaveEstablishment {
    EstablishmentWithAddress perform(EstablishmentWithAddress establishmentWithAddress);
}
