package br.com.ecb.establishmentapi.data.repositories.establishment;

import br.com.ecb.establishmentapi.domain.models.EstablishmentEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface EstablishmentEmployeeRepository extends JpaRepository<EstablishmentEmployee, BigInteger> {
}
