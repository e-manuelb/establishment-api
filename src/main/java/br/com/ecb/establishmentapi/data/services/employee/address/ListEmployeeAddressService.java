package br.com.ecb.establishmentapi.data.services.employee.address;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeAddressRepository;
import br.com.ecb.establishmentapi.domain.features.employee.address.ListEmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListEmployeeAddressService implements ListEmployeeAddress {
    private EmployeeAddressRepository employeeAddressRepository;

    public ListEmployeeAddressService(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    public List<EmployeeAddress> perform() {

        return this.employeeAddressRepository.findAll();
    }
}
