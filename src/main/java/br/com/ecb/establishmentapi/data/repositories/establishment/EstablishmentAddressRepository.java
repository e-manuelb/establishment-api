package br.com.ecb.establishmentapi.data.repositories.establishment;

import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface EstablishmentAddressRepository extends JpaRepository<EstablishmentAddress, BigInteger> {
    EstablishmentAddress findByEstablishmentId(BigInteger id);

    void deleteByEstablishmentId(BigInteger id);
}
