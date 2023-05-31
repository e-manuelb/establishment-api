package br.com.ecb.establishmentapi.shared.dtos.request.establishmentEmployee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigInteger;
import java.util.Set;

public class SaveEstablishmentEmployeeDTOTest {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testValidSaveEstablishmentEmployeeDTO() {
        SaveEstablishmentEmployeeDTO saveEstablishmentEmployeeDTO = new SaveEstablishmentEmployeeDTO();

        saveEstablishmentEmployeeDTO.setEmployeeId(BigInteger.valueOf(1));
        saveEstablishmentEmployeeDTO.setEstablishmentId(BigInteger.valueOf(1));

        Set<ConstraintViolation<SaveEstablishmentEmployeeDTO>> violations = validator.validate(saveEstablishmentEmployeeDTO);

        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    public void testNullEmployeeId() {
        SaveEstablishmentEmployeeDTO saveEstablishmentEmployeeDTO = new SaveEstablishmentEmployeeDTO();

        saveEstablishmentEmployeeDTO.setEmployeeId(null);
        saveEstablishmentEmployeeDTO.setEstablishmentId(BigInteger.valueOf(1));

        Set<ConstraintViolation<SaveEstablishmentEmployeeDTO>> violations = validator.validate(saveEstablishmentEmployeeDTO);

        Assertions.assertEquals(1, violations.size());
        ConstraintViolation<SaveEstablishmentEmployeeDTO> violation = violations.iterator().next();
        Assertions.assertEquals("Employee ID is required.", violation.getMessage());
    }

    @Test
    public void testNullEstablishmentId() {
        SaveEstablishmentEmployeeDTO saveEstablishmentEmployeeDTO = new SaveEstablishmentEmployeeDTO();

        saveEstablishmentEmployeeDTO.setEmployeeId(BigInteger.valueOf(1));
        saveEstablishmentEmployeeDTO.setEstablishmentId(null);

        Set<ConstraintViolation<SaveEstablishmentEmployeeDTO>> violations = validator.validate(saveEstablishmentEmployeeDTO);

        Assertions.assertEquals(1, violations.size());
        ConstraintViolation<SaveEstablishmentEmployeeDTO> violation = violations.iterator().next();
        Assertions.assertEquals("Establishment ID is required.", violation.getMessage());
    }
}
