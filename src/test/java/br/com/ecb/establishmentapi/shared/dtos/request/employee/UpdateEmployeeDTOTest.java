package br.com.ecb.establishmentapi.shared.dtos.request.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigInteger;
import java.util.Set;

public class UpdateEmployeeDTOTest {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testValidUpdateEmployeeDTO() {
        UpdateEmployeeDTO updateEmployeeDTO = new UpdateEmployeeDTO();

        updateEmployeeDTO.setEmployeeId(BigInteger.valueOf(1));
        updateEmployeeDTO.setName("John Doe");
        updateEmployeeDTO.setPhotoUrl("https://example.com/photo.jpg");
        updateEmployeeDTO.setPhone("123456789");
        updateEmployeeDTO.setRole("Manager");
        updateEmployeeDTO.setEmployeeAddressId(BigInteger.valueOf(1));
        updateEmployeeDTO.setAddress("123 Main Street");
        updateEmployeeDTO.setNumber("1A");
        updateEmployeeDTO.setComplement("Apartment 5");
        updateEmployeeDTO.setNeighborhood("Downtown");
        updateEmployeeDTO.setCep("12345-678");
        updateEmployeeDTO.setCity("City");
        updateEmployeeDTO.setState("State");

        Set<ConstraintViolation<UpdateEmployeeDTO>> violations = validator.validate(updateEmployeeDTO);

        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    public void testEmptyUpdateEmployeeDTO() {
        UpdateEmployeeDTO updateEmployeeDTO = new UpdateEmployeeDTO();

        Set<ConstraintViolation<UpdateEmployeeDTO>> violations = validator.validate(updateEmployeeDTO);

        Assertions.assertEquals(13, violations.size());
    }
}
