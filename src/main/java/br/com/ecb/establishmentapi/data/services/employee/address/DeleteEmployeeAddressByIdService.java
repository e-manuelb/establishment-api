package br.com.ecb.establishmentapi.data.services.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.domain.features.employee.address.DeleteEmployeeAddressById;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
public class DeleteEmployeeAddressByIdService implements DeleteEmployeeAddressById {
    private EmployeeAddressRepository employeeAddressRepository;

    public DeleteEmployeeAddressByIdService(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    public void perform(BigInteger id) {
        this.employeeAddressRepository.deleteById(id);
    }
}
