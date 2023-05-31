package br.com.ecb.establishmentapi.shared.dtos.response;

import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
public class EstablishmentWithAddressDTO {
    public BigInteger id;
    public String name;
    public String phone;
    public EstablishmentAddress address;
    public Timestamp createdAt;
    public Timestamp updatedAt;

    public EstablishmentWithAddressDTO(BigInteger id, String name, String phone, EstablishmentAddress address, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
