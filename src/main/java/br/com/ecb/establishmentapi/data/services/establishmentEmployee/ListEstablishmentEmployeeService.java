package br.com.ecb.establishmentapi.data.services.establishmentEmployee;

import br.com.ecb.establishmentapi.data.repositories.establishment.EstablishmentEmployeeRepository;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.ListEstablishmentEmployee;
import br.com.ecb.establishmentapi.domain.models.EstablishmentEmployee;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListEstablishmentEmployeeService implements ListEstablishmentEmployee {
    private EstablishmentEmployeeRepository establishmentEmployeeRepository;

    public ListEstablishmentEmployeeService(EstablishmentEmployeeRepository establishmentEmployeeRepository) {
        this.establishmentEmployeeRepository = establishmentEmployeeRepository;
    }

    public List<EstablishmentEmployee> perform() {
        return establishmentEmployeeRepository.findAll();
    }
}
