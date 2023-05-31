package br.com.ecb.establishmentapi.shared.dtos.request.establishment;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class SaveEstablishmentDTO {
    // Establishment info
    @NotEmpty(message = "Name is required.")
    public String name;


    @NotEmpty(message = "Phone is required.")
    public String phone;

    // Address info
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
}
