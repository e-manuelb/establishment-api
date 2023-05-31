package br.com.ecb.establishmentapi.domain.features.establishment.address;

import java.math.BigInteger;

public interface DeleteEstablishmentAddressById {
    void perform(BigInteger id);
}
