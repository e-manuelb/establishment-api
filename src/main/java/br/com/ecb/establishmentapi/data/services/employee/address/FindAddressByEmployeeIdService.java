package br.com.ecb.establishmentapi.data.services.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.domain.features.employee.address.FindAddressByEmployeeId;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class FindAddressByEmployeeIdService implements FindAddressByEmployeeId {
    private EmployeeAddressRepository employeeAddressRepository;

    public FindAddressByEmployeeIdService(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    public Optional<EmployeeAddress> perform(BigInteger id) throws Exception {
        Optional<EmployeeAddress> employeeAddress = this.employeeAddressRepository.findByEmployeeId(id);

        if (employeeAddress == null) {
            throw new Exception("Employee Address with Employee ID #" + id + " not found.");
        }

        return employeeAddress;
    }
}
