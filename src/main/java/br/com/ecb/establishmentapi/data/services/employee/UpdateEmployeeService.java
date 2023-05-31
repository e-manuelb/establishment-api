package br.com.ecb.establishmentapi.data.services.employee;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeRepository;
import br.com.ecb.establishmentapi.domain.features.employee.UpdateEmployee;
import br.com.ecb.establishmentapi.domain.features.employee.address.UpdateEmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.Employee;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateEmployeeService implements UpdateEmployee {
    private EmployeeRepository employeeRepository;

    private UpdateEmployeeAddress updateEmployeeAddressService;

    public UpdateEmployeeService(EmployeeRepository employeeRepository, UpdateEmployeeAddress updateEmployeeAddressService) {
        this.employeeRepository = employeeRepository;
        this.updateEmployeeAddressService = updateEmployeeAddressService;
    }

    public EmployeeWithAddress perform(EmployeeWithAddress employeeWithAddress) throws Exception {

        Optional<Employee> employeeToUpdate = this.employeeRepository.findById(employeeWithAddress.getEmployee().getId());

        if (employeeToUpdate == null) {
            throw new Exception("Employee with ID #" + employeeWithAddress.getEmployee().getId() + " not found.");
        }

        Employee employeeUpdated = this.employeeRepository.save(employeeWithAddress.getEmployee());
        EmployeeAddress employeeAddressUpdated = this.updateEmployeeAddressService.perform(employeeWithAddress.getAddress());

        return new EmployeeWithAddress(
                employeeUpdated,
                employeeAddressUpdated
        );
    }
}
