package br.com.ecb.establishmentapi.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EstablishmentWithAddress {
    private Establishment establishment;
    private EstablishmentAddress address;
}
