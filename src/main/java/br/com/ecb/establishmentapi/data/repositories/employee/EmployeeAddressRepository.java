package br.com.ecb.establishmentapi.data.repositories.employee;

import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, BigInteger> {
    Optional<EmployeeAddress> findByEmployeeId(BigInteger employeeId);

    void deleteByEmployeeId(BigInteger employeeId);
}
