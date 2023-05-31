package br.com.ecb.establishmentapi.main.routes.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.FindEstablishmentByIdController;
import br.com.ecb.establishmentapi.domain.features.establishment.FindEstablishmentById;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import br.com.ecb.establishmentapi.main.factories.controllers.establishment.FindEstablishmentByIdControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentWithAddressDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/v1/establishment")
public class FindEstablishmentByIdRoute {
    private FindEstablishmentById findEstablishmentByIdService;

    public FindEstablishmentByIdRoute(FindEstablishmentById findEstablishmentByIdService) {
        this.findEstablishmentByIdService = findEstablishmentByIdService;
    }

    @GetMapping("/{id}")
    EstablishmentWithAddressDTO perform(@PathVariable BigInteger id) throws Exception {
        FindEstablishmentByIdController findEstablishmentByIdController = new FindEstablishmentByIdControllerFactory(findEstablishmentByIdService).makeFindEstablishmentByIdController();

        EstablishmentWithAddress establishmentWithAddress = findEstablishmentByIdController.perform(id);

        return new EstablishmentWithAddressDTO(
                establishmentWithAddress.getAddress().getId(),
                establishmentWithAddress.getEstablishment().getName(),
                establishmentWithAddress.getEstablishment().getPhone(),
                establishmentWithAddress.getAddress(),
                establishmentWithAddress.getEstablishment().getCreatedAt(),
                establishmentWithAddress.getEstablishment().getUpdatedAt()
        );
    }
}
