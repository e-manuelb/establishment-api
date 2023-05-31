package br.com.ecb.establishmentapi.data.services.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.domain.features.employee.address.DeleteAddressByEmployeeId;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
public class DeleteAddressByEmployeeIdService implements DeleteAddressByEmployeeId {
    private EmployeeAddressRepository employeeAddressRepository;

    public DeleteAddressByEmployeeIdService(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    public void perform(BigInteger id) {
        employeeAddressRepository.deleteByEmployeeId(id);
    }
}
