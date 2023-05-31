package br.com.ecb.establishmentapi.shared.dtos.request.employee;

import br.com.ecb.establishmentapi.domain.models.Employee;
import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import br.com.ecb.establishmentapi.domain.models.EmployeeWithAddress;
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
public class UpdateEmployeeDTO {
    // Employee info
    @NotNull(message = "Employee ID is required.")
    public BigInteger employeeId;

    @NotEmpty(message = "Name is required.")
    public String name;

    @NotEmpty(message = "Photo URL is required.")
    public String photoUrl;

    @NotEmpty(message = "Phone is required.")
    public String phone;

    @NotEmpty(message = "Role is required.")
    public String role;

    // Address info
    @NotNull(message = "Employee Address ID is required.")
    public BigInteger employeeAddressId;

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

    public EmployeeWithAddress toEmployeeWithAddress() {
        return new EmployeeWithAddress(
                new Employee()
                        .setId(this.getEmployeeId())
                        .setName(this.getName())
                        .setPhotoUrl(this.getPhotoUrl())
                        .setPhone(this.getPhone())
                        .setRole(this.getRole()),
                new EmployeeAddress()
                        .setId(this.getEmployeeAddressId())
                        .setAddress(this.getAddress())
                        .setNumber(this.getNumber())
                        .setComplement(this.getComplement())
                        .setNeighborhood(this.getNeighborhood())
                        .setCep(this.getCep())
                        .setCity(this.getCity())
                        .setState(this.getState())
                        .setEmployeeId(this.getEmployeeId())
        );
    }
}
