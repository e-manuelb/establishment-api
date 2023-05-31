package br.com.ecb.establishmentapi.data.services.employee;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeRepository;
import br.com.ecb.establishmentapi.domain.features.employee.FindEmployeeById;
import br.com.ecb.establishmentapi.domain.features.employee.address.FindAddressByEmployeeId;
import br.com.ecb.establishmentapi.domain.models.Employee;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class FindEmployeeByIdService implements FindEmployeeById {
    private EmployeeRepository employeeRepository;
    private FindAddressByEmployeeId findAddressByEmployeeIdService;

    public FindEmployeeByIdService(EmployeeRepository employeeRepository, FindAddressByEmployeeId findAddressByEmployeeIdService) {
        this.employeeRepository = employeeRepository;
        this.findAddressByEmployeeIdService = findAddressByEmployeeIdService;
    }

    public EmployeeWithAddress perform(BigInteger id) throws Exception {
        Employee employee = this.employeeRepository.findById(id).get();

        if (employee == null) {
            throw new Exception("Employee with ID #" + id + " not found.");
        }

        EmployeeAddress address = this.findAddressByEmployeeIdService.perform(id).get();

        return new EmployeeWithAddress(
                new Employee()
                        .setId(employee.getId())
                        .setName(employee.getName())
                        .setPhotoUrl(employee.getPhotoUrl())
                        .setPhone(employee.getPhone())
                        .setRole(employee.getRole()),
                new EmployeeAddress()
                        .setId(address.getId())
                        .setAddress(address.getAddress())
                        .setNumber(address.getNumber())
                        .setComplement(address.getComplement())
                        .setNeighborhood(address.getNeighborhood())
                        .setCep(address.getCep())
                        .setCity(address.getCity())
                        .setState(address.getState())
                        .setEmployeeId(address.getEmployeeId())
        );
    }
}
