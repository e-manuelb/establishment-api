package br.com.ecb.establishmentapi.data.services.establishmentEmployee;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentEmployeeRepository;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.SaveEstablishmentEmployee;
import br.com.ecb.establishmentapi.domain.models.EstablishmentEmployee;
import org.springframework.stereotype.Service;

@Service
public class SaveEstablishmentEmployeeService implements SaveEstablishmentEmployee {
    private EstablishmentEmployeeRepository establishmentEmployeeRepository;

    public SaveEstablishmentEmployeeService(EstablishmentEmployeeRepository establishmentEmployeeRepository) {
        this.establishmentEmployeeRepository = establishmentEmployeeRepository;
    }

    public EstablishmentEmployee perform(EstablishmentEmployee establishmentEmployee) {
        return this.establishmentEmployeeRepository.save(establishmentEmployee);
    }
}
