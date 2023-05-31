package br.com.ecb.establishmentapi.data.services.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.domain.features.employee.address.FindEmployeeAddressById;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class FindEmployeeAddressByIdService implements FindEmployeeAddressById {
    private EmployeeAddressRepository employeeAddressRepository;

    public FindEmployeeAddressByIdService(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    public Optional<EmployeeAddress> perform(BigInteger id) {
        return this.employeeAddressRepository.findById(id);
    }
}
