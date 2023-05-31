package br.com.ecb.establishmentapi.data.services.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.domain.features.employee.address.SaveEmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import org.springframework.stereotype.Service;

@Service
public class SaveEmployeeAddressService implements SaveEmployeeAddress {
    private EmployeeAddressRepository employeeAddressRepository;

    public SaveEmployeeAddressService(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    public EmployeeAddress perform(EmployeeAddress employeeAddress) {
        return this.employeeAddressRepository.save(employeeAddress);
    }
}
