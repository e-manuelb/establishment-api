package br.com.ecb.establishmentapi.data.services.establishmentEmployee;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentEmployeeRepository;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.DeleteEstablishmentEmployeeById;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
public class DeleteEstablishmentEmployeeByIdService implements DeleteEstablishmentEmployeeById {
    private EstablishmentEmployeeRepository establishmentEmployeeRepository;

    public DeleteEstablishmentEmployeeByIdService(EstablishmentEmployeeRepository establishmentEmployeeRepository) {
        this.establishmentEmployeeRepository = establishmentEmployeeRepository;
    }

    public void perform(BigInteger id) {
        this.establishmentEmployeeRepository.deleteById(id);
    }
}
