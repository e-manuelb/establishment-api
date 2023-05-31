package br.com.ecb.establishmentapi.domain.features.employee;

import java.math.BigInteger;

public interface DeleteEmployeeById {
    void perform(BigInteger id);
}
