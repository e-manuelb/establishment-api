package br.com.ecb.establishmentapi.shared.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
public class EstablishmentEmployeeDTO {
    public BigInteger id;
    public BigInteger employeeId;
    public BigInteger establishmentId;
    public Timestamp createAt;
    public Timestamp updatedAt;

    public EstablishmentEmployeeDTO(BigInteger id, BigInteger employeeId, BigInteger establishmentId, Timestamp createAt, Timestamp updatedAt) {
        this.id = id;
        this.employeeId = employeeId;
        this.establishmentId = establishmentId;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }
}
