package br.com.ecb.establishmentapi.domain.features.employee.address;

import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ListEmployeeAddress {
    List<EmployeeAddress> perform();
}
