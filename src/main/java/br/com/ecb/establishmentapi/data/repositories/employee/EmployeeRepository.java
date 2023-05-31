package br.com.ecb.establishmentapi.data.repositories.employee;

import br.com.ecb.establishmentapi.domain.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {
}
