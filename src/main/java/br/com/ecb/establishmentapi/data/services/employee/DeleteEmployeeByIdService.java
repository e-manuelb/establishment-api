package br.com.ecb.establishmentapi.data.services.employee;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeRepository;
import br.com.ecb.establishmentapi.domain.features.employee.DeleteEmployeeById;
import br.com.ecb.establishmentapi.domain.features.employee.address.DeleteAddressByEmployeeId;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
public class DeleteEmployeeByIdService implements DeleteEmployeeById {
    private EmployeeRepository employeeRepository;
    private DeleteAddressByEmployeeId deleteAddressByEmployeeIdService;

    public DeleteEmployeeByIdService(EmployeeRepository employeeRepository, DeleteAddressByEmployeeId deleteAddressByEmployeeIdService) {
        this.employeeRepository = employeeRepository;
        this.deleteAddressByEmployeeIdService = deleteAddressByEmployeeIdService;
    }

    public void perform(BigInteger id) {
        deleteAddressByEmployeeIdService.perform(id);
        this.employeeRepository.deleteById(id);
    }
}
