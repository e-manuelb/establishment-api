package br.com.ecb.establishmentapi.data.services.employee;

import br.com.ecb.establishmentapi.data.repositories.employee.EmployeeRepository;
import br.com.ecb.establishmentapi.domain.features.employee.ListEmployee;
import br.com.ecb.establishmentapi.domain.features.employee.address.FindAddressByEmployeeId;
import br.com.ecb.establishmentapi.domain.models.Employee;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListEmployeeService implements ListEmployee {
    private EmployeeRepository employeeRepository;

    private FindAddressByEmployeeId findAddressByEmployeeId;

    public ListEmployeeService(EmployeeRepository employeeRepository, FindAddressByEmployeeId findAddressByEmployeeId) {
        this.employeeRepository = employeeRepository;
        this.findAddressByEmployeeId = findAddressByEmployeeId;
    }

    public List<EmployeeWithAddress> perform() {
        List<Employee> employees = this.employeeRepository.findAll();

        List<EmployeeWithAddress> employeesWithAddress = new ArrayList<>();

        employees.forEach(employee -> {
            try {
                EmployeeAddress address = this.findAddressByEmployeeId.perform(employee.getId()).get();

                employeesWithAddress.add(new EmployeeWithAddress(employee, address));

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return employeesWithAddress;
    }
}
