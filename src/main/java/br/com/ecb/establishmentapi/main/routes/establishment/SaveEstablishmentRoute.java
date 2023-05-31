package br.com.ecb.establishmentapi.main.routes.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.SaveEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.SaveEstablishment;
import br.com.ecb.establishmentapi.domain.models.Establishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentAddress;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import br.com.ecb.establishmentapi.main.factories.controllers.establishment.SaveEstablishmentControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentWithAddressDTO;
import br.com.ecb.establishmentapi.shared.dtos.request.establishment.SaveEstablishmentDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/establishment")
public class SaveEstablishmentRoute {
    private SaveEstablishment saveEstablishmentService;

    public SaveEstablishmentRoute(SaveEstablishment saveEstablishmentService) {
        this.saveEstablishmentService = saveEstablishmentService;
    }

    @PostMapping("/")
    public EstablishmentWithAddressDTO perform(@RequestBody SaveEstablishmentDTO saveEstablishmentDTO) {
        SaveEstablishmentController saveEstablishmentController = new SaveEstablishmentControllerFactory(saveEstablishmentService).makeSaveEstablishmentController();

        EstablishmentWithAddress establishmentWithAddress = saveEstablishmentController.perform(
                new EstablishmentWithAddress(
                        new Establishment()
                                .setName(saveEstablishmentDTO.getName())
                                .setPhone(saveEstablishmentDTO.getPhone()),
                        new EstablishmentAddress()
                                .setAddress(saveEstablishmentDTO.getAddress())
                                .setNumber(saveEstablishmentDTO.getNumber())
                                .setComplement(saveEstablishmentDTO.getComplement())
                                .setNeighborhood(saveEstablishmentDTO.getNeighborhood())
                                .setCep(saveEstablishmentDTO.getCep())
                                .setCity(saveEstablishmentDTO.getCity())
                                .setState(saveEstablishmentDTO.getState())
                )
        );

        return new EstablishmentWithAddressDTO(
                establishmentWithAddress.getEstablishment().getId(),
                establishmentWithAddress.getEstablishment().getName(),
                establishmentWithAddress.getEstablishment().getPhone(),
                establishmentWithAddress.getAddress(),
                establishmentWithAddress.getEstablishment().getCreatedAt(),
                establishmentWithAddress.getEstablishment().getUpdatedAt()
        );
    }
}
