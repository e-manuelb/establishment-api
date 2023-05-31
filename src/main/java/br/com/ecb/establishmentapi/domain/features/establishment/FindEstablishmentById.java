package br.com.ecb.establishmentapi.domain.features.establishment;

import br.com.ecb.establishmentapi.domain.models.Establishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;

import java.math.BigInteger;
import java.util.Optional;

public interface FindEstablishmentById {
    EstablishmentWithAddress perform(BigInteger id) throws Exception;
}
