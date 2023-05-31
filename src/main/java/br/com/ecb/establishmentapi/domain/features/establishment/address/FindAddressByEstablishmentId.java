package br.com.ecb.establishmentapi.domain.features.establishment.address;

import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;

import java.math.BigInteger;

public interface FindAddressByEstablishmentId {
    EstablishmentAddress perform(BigInteger id);
}
