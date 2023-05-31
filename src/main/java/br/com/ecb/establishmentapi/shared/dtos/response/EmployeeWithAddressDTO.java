package br.com.ecb.establishmentapi.shared.dtos.response;

import br.com.ecb.establishmentapi.domain.models.EmployeeAddress;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
public class EmployeeWithAddressDTO {
    private BigInteger id;
    public String name;
    public String photoUrl;
    public String phone;
    public String role;
    public EmployeeAddress address;
    public Timestamp createdAt;
    public Timestamp updatedAt;

    public EmployeeWithAddressDTO(BigInteger id, String name, String photoUrl, String phone, String role, EmployeeAddress address, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.phone = phone;
        this.role = role;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
