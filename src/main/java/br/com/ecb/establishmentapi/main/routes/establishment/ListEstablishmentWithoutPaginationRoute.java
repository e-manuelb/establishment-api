package br.com.ecb.establishmentapi.main.routes.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.ListEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.ListEstablishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import br.com.ecb.establishmentapi.main.factories.controllers.establishment.ListEstablishmentControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentWithAddressDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/establishment")
public class ListEstablishmentWithoutPaginationRoute {
    private ListEstablishment listEstablishmentService;

    public ListEstablishmentWithoutPaginationRoute(ListEstablishment listEstablishmentService) {
        this.listEstablishmentService = listEstablishmentService;
    }

    @GetMapping("/all")
    public List<EstablishmentWithAddressDTO> perform() {
        ListEstablishmentController listEstablishmentController = new ListEstablishmentControllerFactory(listEstablishmentService).makeListEstablishmentController();

        List<EstablishmentWithAddress> establishmentWithAddresses = listEstablishmentController.perform();

        List<EstablishmentWithAddressDTO> establishmentWithAddressDTOS = new ArrayList<>();

        establishmentWithAddresses.forEach(establishmentWithAddress -> {
            establishmentWithAddressDTOS.add(
                    new EstablishmentWithAddressDTO(
                            establishmentWithAddress.getEstablishment().getId(),
                            establishmentWithAddress.getEstablishment().getName(),
                            establishmentWithAddress.getEstablishment().getPhone(),
                            establishmentWithAddress.getAddress(),
                            establishmentWithAddress.getEstablishment().getCreatedAt(),
                            establishmentWithAddress.getEstablishment().getUpdatedAt()
                    )
            );
        });

        return establishmentWithAddressDTOS;
    }
}
