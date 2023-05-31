package br.com.ecb.establishmentapi.domain.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "establishment_addresses")
public class EstablishmentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "address", nullable = false)
    public String address;

    @Column(name = "number", nullable = false)
    public String number;

    @Column(name = "complement", nullable = false)
    public String complement;

    @Column(name = "neighborhood", nullable = false)
    public String neighborhood;

    @Column(name = "cep", nullable = false)
    public String cep;

    @Column(name = "city", nullable = false)
    public String city;

    @Column(name = "state", nullable = false)
    public String state;

    @Column(name = "establishment_id", nullable = false)
    public BigInteger establishmentId;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
