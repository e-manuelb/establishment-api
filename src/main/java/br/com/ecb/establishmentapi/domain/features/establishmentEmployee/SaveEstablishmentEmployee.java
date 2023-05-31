package br.com.ecb.establishmentapi.domain.features.establishmentEmployee;

import br.com.ecb.establishmentapi.domain.models.EstablishmentEmployee;

public interface SaveEstablishmentEmployee {
    EstablishmentEmployee perform(EstablishmentEmployee establishmentEmployee);
}
