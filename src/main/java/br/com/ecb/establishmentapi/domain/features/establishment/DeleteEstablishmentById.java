package br.com.ecb.establishmentapi.domain.features.establishment;

import java.math.BigInteger;

public interface DeleteEstablishmentById {
    void perform(BigInteger id);
}
