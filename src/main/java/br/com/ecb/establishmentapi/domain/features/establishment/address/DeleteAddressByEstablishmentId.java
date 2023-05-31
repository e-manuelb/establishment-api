package br.com.ecb.establishmentapi.domain.features.establishment.address;

import java.math.BigInteger;

public interface DeleteAddressByEstablishmentId {
    void perform(BigInteger id);
}
