package br.com.ecb.establishmentapi.domain.features.employee.address;

import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;

import java.math.BigInteger;
import java.util.Optional;

public interface FindAddressByEmployeeId {
    Optional<EmployeeAddress> perform(BigInteger id) throws Exception;
}
