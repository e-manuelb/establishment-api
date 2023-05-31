package br.com.ecb.establishmentapi.shared.dtos.request.establishmentEmployee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SaveEstablishmentEmployeeDTO {
    @NotNull(message = "Employee ID is required.")
    public BigInteger employeeId;

    @NotNull(message = "Establishment ID is required.")
    public BigInteger establishmentId;
}
