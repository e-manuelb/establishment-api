package br.com.ecb.establishmentapi.shared.dtos.request.establishment;

import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigInteger;
import java.util.Set;

public class UpdateEstablishmentDTOTest {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testValidUpdateEstablishmentDTO() {
        UpdateEstablishmentDTO updateEstablishmentDTO = new UpdateEstablishmentDTO();

        updateEstablishmentDTO.setEstablishmentId(BigInteger.valueOf(1));
        updateEstablishmentDTO.setName("Example Establishment");
        updateEstablishmentDTO.setPhone("1234567890");
        updateEstablishmentDTO.setEstablishmentAddressId(BigInteger.valueOf(1));
        updateEstablishmentDTO.setAddress("Example Street");
        updateEstablishmentDTO.setNumber("123");
        updateEstablishmentDTO.setComplement("Apartment 4");
        updateEstablishmentDTO.setNeighborhood("Example Neighborhood");
        updateEstablishmentDTO.setCep("12345-678");
        updateEstablishmentDTO.setCity("Example City");
        updateEstablishmentDTO.setState("Example State");

        Set<ConstraintViolation<UpdateEstablishmentDTO>> violations = validator.validate(updateEstablishmentDTO);

        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    public void testNullEstablishmentId() {
        UpdateEstablishmentDTO updateEstablishmentDTO = new UpdateEstablishmentDTO();

        updateEstablishmentDTO.setEstablishmentId(null);
        updateEstablishmentDTO.setName("Example Establishment");
        updateEstablishmentDTO.setPhone("1234567890");
        updateEstablishmentDTO.setEstablishmentAddressId(BigInteger.valueOf(1));
        updateEstablishmentDTO.setAddress("Example Street");
        updateEstablishmentDTO.setNumber("123");
        updateEstablishmentDTO.setComplement("Apartment 4");
        updateEstablishmentDTO.setNeighborhood("Example Neighborhood");
        updateEstablishmentDTO.setCep("12345-678");
        updateEstablishmentDTO.setCity("Example City");
        updateEstablishmentDTO.setState("Example State");

        Set<ConstraintViolation<UpdateEstablishmentDTO>> violations = validator.validate(updateEstablishmentDTO);

        Assertions.assertEquals(1, violations.size());
        ConstraintViolation<UpdateEstablishmentDTO> violation = violations.iterator().next();
        Assertions.assertEquals("Establishment ID is required.", violation.getMessage());
    }

    @Test
    public void testEmptyName() {
        UpdateEstablishmentDTO updateEstablishmentDTO = new UpdateEstablishmentDTO();

        updateEstablishmentDTO.setEstablishmentId(BigInteger.valueOf(1));
        updateEstablishmentDTO.setName("");
        updateEstablishmentDTO.setPhone("1234567890");
        updateEstablishmentDTO.setEstablishmentAddressId(BigInteger.valueOf(1));
        updateEstablishmentDTO.setAddress("Example Street");
        updateEstablishmentDTO.setNumber("123");
        updateEstablishmentDTO.setComplement("Apartment 4");
        updateEstablishmentDTO.setNeighborhood("Example Neighborhood");
        updateEstablishmentDTO.setCep("12345-678");
        updateEstablishmentDTO.setCity("Example City");
        updateEstablishmentDTO.setState("Example State");

        Set<ConstraintViolation<UpdateEstablishmentDTO>> violations = validator.validate(updateEstablishmentDTO);

        Assertions.assertEquals(1, violations.size());
        ConstraintViolation<UpdateEstablishmentDTO> violation = violations.iterator().next();
        Assertions.assertEquals("Name is required.", violation.getMessage());
    }
}
