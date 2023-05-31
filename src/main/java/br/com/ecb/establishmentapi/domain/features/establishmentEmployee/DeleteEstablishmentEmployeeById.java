package br.com.ecb.establishmentapi.domain.features.establishmentEmployee;

import java.math.BigInteger;

public interface DeleteEstablishmentEmployeeById {
    void perform(BigInteger id);
}
