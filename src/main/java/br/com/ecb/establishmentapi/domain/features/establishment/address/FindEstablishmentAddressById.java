package br.com.ecb.establishmentapi.domain.features.establishment.address;

import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;

import java.math.BigInteger;
import java.util.Optional;

public interface FindEstablishmentAddressById {
    Optional<EstablishmentAddress> perform(BigInteger id);
}
