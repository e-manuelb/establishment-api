package br.com.ecb.establishmentapi.data.services.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.domain.features.employee.address.UpdateEmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateEmployeeAddressService implements UpdateEmployeeAddress {
    private EmployeeAddressRepository employeeAddressRepository;

    public UpdateEmployeeAddressService(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    public EmployeeAddress perform(EmployeeAddress employeeAddress) throws Exception {
        Optional<EmployeeAddress> employeeAddressToUpdate = this.employeeAddressRepository.findById(employeeAddress.getId());

        if (employeeAddressToUpdate == null) {
            throw new Exception("Employee address with ID #" + employeeAddress.getId() + " not found.");
        }

        return this.employeeAddressRepository.save(employeeAddress);
    }
}
