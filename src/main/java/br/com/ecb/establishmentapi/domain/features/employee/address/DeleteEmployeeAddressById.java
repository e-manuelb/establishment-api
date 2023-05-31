package br.com.ecb.establishmentapi.domain.features.employee.address;

import java.math.BigInteger;

public interface DeleteEmployeeAddressById {
    void perform(BigInteger id);
}
