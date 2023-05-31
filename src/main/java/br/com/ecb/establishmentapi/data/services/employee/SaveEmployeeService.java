package br.com.ecb.establishmentapi.data.services.employee;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeRepository;
import br.com.ecb.establishmentapi.domain.features.employee.SaveEmployee;
import br.com.ecb.establishmentapi.domain.features.employee.address.SaveEmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.Employee;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import org.springframework.stereotype.Service;

@Service
public class SaveEmployeeService implements SaveEmployee {
    private EmployeeRepository employeeRepository;

    private SaveEmployeeAddress saveEmployeeAddress;

    public SaveEmployeeService(EmployeeRepository employeeRepository, SaveEmployeeAddress saveEmployeeAddress) {
        this.employeeRepository = employeeRepository;
        this.saveEmployeeAddress = saveEmployeeAddress;
    }

    public EmployeeWithAddress perform(EmployeeWithAddress employeeWithAddress) {
        Employee employee = this.employeeRepository.save(
                new Employee()
                        .setName(employeeWithAddress.getEmployee().getName())
                        .setPhone(employeeWithAddress.getEmployee().getPhone())
                        .setPhotoUrl(employeeWithAddress.getEmployee().getPhotoUrl())
                        .setRole(employeeWithAddress.getEmployee().getRole())
        );

        EmployeeAddress employeeAddress = this.saveEmployeeAddress.perform(
                new EmployeeAddress()
                        .setAddress(employeeWithAddress.getAddress().getAddress())
                        .setNumber(employeeWithAddress.getAddress().getNumber())
                        .setComplement(employeeWithAddress.getAddress().getComplement())
                        .setNeighborhood(employeeWithAddress.getAddress().getNeighborhood())
                        .setCep(employeeWithAddress.getAddress().getCep())
                        .setCity(employeeWithAddress.getAddress().getCity())
                        .setState(employeeWithAddress.getAddress().getState())
                        .setEmployeeId(employee.getId())
        );

        return new EmployeeWithAddress(employee, employeeAddress);
    }
}
