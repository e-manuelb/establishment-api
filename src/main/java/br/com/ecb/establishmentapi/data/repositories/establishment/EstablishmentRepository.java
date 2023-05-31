package br.com.ecb.establishmentapi.data.repositories.establishment;

import br.com.ecb.establishmentapi.domain.models.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface EstablishmentRepository extends JpaRepository<Establishment, BigInteger> {
}
