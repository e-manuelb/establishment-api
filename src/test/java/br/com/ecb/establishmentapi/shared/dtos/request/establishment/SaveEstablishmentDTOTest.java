package br.com.ecb.establishmentapi.shared.dtos.request.establishment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class SaveEstablishmentDTOTest {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testValidSaveEstablishmentDTO() {
        SaveEstablishmentDTO saveEstablishmentDTO = new SaveEstablishmentDTO();

        saveEstablishmentDTO.setName("Example Establishment");
        saveEstablishmentDTO.setPhone("1234567890");
        saveEstablishmentDTO.setAddress("Example Street");
        saveEstablishmentDTO.setNumber("123");
        saveEstablishmentDTO.setComplement("Apartment 4");
        saveEstablishmentDTO.setNeighborhood("Example Neighborhood");
        saveEstablishmentDTO.setCep("12345-678");
        saveEstablishmentDTO.setCity("Example City");
        saveEstablishmentDTO.setState("Example State");

        Set<ConstraintViolation<SaveEstablishmentDTO>> violations = validator.validate(saveEstablishmentDTO);

        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    public void testEmpty() {
        SaveEstablishmentDTO saveEstablishmentDTO = new SaveEstablishmentDTO();

        Set<ConstraintViolation<SaveEstablishmentDTO>> violations = validator.validate(saveEstablishmentDTO);

        Assertions.assertEquals(9, violations.size());
    }
}
