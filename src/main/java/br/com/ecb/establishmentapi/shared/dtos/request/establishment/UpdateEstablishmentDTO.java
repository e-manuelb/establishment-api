package br.com.ecb.establishmentapi.shared.dtos.request.establishment;

import br.com.ecb.establishmentapi.domain.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigInteger;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEstablishmentDTO {
    // Establishment info
    @NotNull(message = "Establishment ID is required.")
    public BigInteger establishmentId;

    @NotEmpty(message = "Name is required.")
    public String name;

    @NotEmpty(message = "Phone is required.")
    public String phone;

    // Address info
    @NotNull(message = "Establishment Address ID is required.")
    public BigInteger establishmentAddressId;

    @NotEmpty(message = "Address is required.")
    public String address;

    @NotEmpty(message = "Number is required.")
    public String number;

    @NotEmpty(message = "Complement is required.")
    public String complement;

    @NotEmpty(message = "Neighborhood is required.")
    public String neighborhood;

    @NotEmpty(message = "CEP is required.")
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE}, message = "CEP is invalid.")
    public String cep;

    @NotEmpty(message = "City is required.")
    public String city;

    @NotEmpty(message = "State is required.")
    public String state;

    public EstablishmentWithAddress toEstablishmentWithAddress() {
        return new EstablishmentWithAddress(
                new Establishment()
                        .setId(this.getEstablishmentId())
                        .setName(this.getName())
                        .setPhone(this.getPhone()),
                new EstablishmentAddress()
                        .setId(this.getEstablishmentAddressId())
                        .setAddress(this.getAddress())
                        .setNumber(this.getNumber())
                        .setComplement(this.getComplement())
                        .setNeighborhood(this.getNeighborhood())
                        .setCep(this.getCep())
                        .setCity(this.getCity())
                        .setState(this.getState())
                        .setEstablishmentId(this.getEstablishmentId())
        );
    }
}
