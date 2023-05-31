package br.com.ecb.establishmentapi.domain.features.establishment;

import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;

import java.util.List;

public interface ListEstablishment {
    List<EstablishmentWithAddress> perform();
}
