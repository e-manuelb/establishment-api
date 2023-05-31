package br.com.ecb.establishmentapi.main.routes.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.UpdateEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.UpdateEstablishment;
import br.com.ecb.establishmentapi.domain.models.EstablishmentWithAddress;
import br.com.ecb.establishmentapi.main.factories.controllers.establishment.UpdateEstablishmentControllerFactory;
import br.com.ecb.establishmentapi.shared.dtos.request.establishment.UpdateEstablishmentDTO;
import br.com.ecb.establishmentapi.shared.dtos.response.EstablishmentWithAddressDTO;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/establishment")
public class UpdateEstablishmentRoute {
    private UpdateEstablishment updateEstablishmentService;

    public UpdateEstablishmentRoute(UpdateEstablishment updateEstablishmentService) {
        this.updateEstablishmentService = updateEstablishmentService;
    }

    @PutMapping("/")
    public EstablishmentWithAddressDTO perform(@RequestBody UpdateEstablishmentDTO updateEstablishmentDTO) throws Exception {
        UpdateEstablishmentController updateEstablishmentController = new UpdateEstablishmentControllerFactory(updateEstablishmentService).makeUpdateEstablishmentController();

        EstablishmentWithAddress establishmentWithAddress = updateEstablishmentController.perform(updateEstablishmentDTO.toEstablishmentWithAddress());

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
