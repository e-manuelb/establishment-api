package br.com.ecb.establishmentapi.shared.dtos.request.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SaveEmployeeDTOTest {
    @Test
    public void testValidation() {
        SaveEmployeeDTO saveEmployeeDTO = new SaveEmployeeDTO();

        saveEmployeeDTO.setName("");
        saveEmployeeDTO.setPhotoUrl("");
        saveEmployeeDTO.setPhone("");
        saveEmployeeDTO.setRole("");
        saveEmployeeDTO.setAddress("");
        saveEmployeeDTO.setNumber("");
        saveEmployeeDTO.setComplement("");
        saveEmployeeDTO.setNeighborhood("");
        saveEmployeeDTO.setCep("");
        saveEmployeeDTO.setCity("");
        saveEmployeeDTO.setState("");

        Set<ConstraintViolation<SaveEmployeeDTO>> violations = Validation.buildDefaultValidatorFactory()
                .getValidator().validate(saveEmployeeDTO);

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(12, violations.size());
    }

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    public void testAllFieldsValid() {
        // Arrange
        SaveEmployeeDTO dto = new SaveEmployeeDTO();
        dto.setName("John Doe");
        dto.setPhotoUrl("https://example.com/photo.jpg");
        dto.setPhone("1234567890");
        dto.setRole("Manager");
        dto.setAddress("123 Main St");
        dto.setNumber("1A");
        dto.setComplement("Apt 2B");
        dto.setNeighborhood("Downtown");
        dto.setCep("12345-678");
        dto.setCity("New York");
        dto.setState("NY");

        // Act
        Set<ConstraintViolation<SaveEmployeeDTO>> violations = validator.validate(dto);

        // Assert
        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    public void testEmptyFields() {
        // Arrange
        SaveEmployeeDTO dto = new SaveEmployeeDTO();

        // Act
        Set<ConstraintViolation<SaveEmployeeDTO>> violations = validator.validate(dto);

        // Assert
        Assertions.assertEquals(11, violations.size());
    }

    @Test
    public void testInvalidCepFormat() {
        SaveEmployeeDTO dto = new SaveEmployeeDTO();
        dto.setName("John Doe");
        dto.setPhotoUrl("https://example.com/photo.jpg");
        dto.setPhone("1234567890");
        dto.setRole("Manager");
        dto.setAddress("123 Main St");
        dto.setNumber("1A");
        dto.setComplement("Apt 2B");
        dto.setNeighborhood("Downtown");
        dto.setCity("New York");
        dto.setState("NY");
        dto.setCep("123456789");

        Set<ConstraintViolation<SaveEmployeeDTO>> violations = validator.validate(dto);

        Assertions.assertEquals(1, violations.size());
        ConstraintViolation<SaveEmployeeDTO> violation = violations.iterator().next();
        Assertions.assertEquals("CEP is invalid.", violation.getMessage());
    }
}
