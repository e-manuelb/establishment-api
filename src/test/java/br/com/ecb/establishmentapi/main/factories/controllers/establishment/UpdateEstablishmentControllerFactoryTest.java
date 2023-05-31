package br.com.ecb.establishmentapi.main.factories.controllers.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.UpdateEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.UpdateEstablishment;
import br.com.ecb.establishmentapi.main.factories.controllers.establishment.UpdateEstablishmentControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UpdateEstablishmentControllerFactoryTest {

    @Test
    public void testMakeUpdateEstablishmentController() {
        UpdateEstablishment updateEstablishmentService = Mockito.mock(UpdateEstablishment.class);

        UpdateEstablishmentControllerFactory factory = new UpdateEstablishmentControllerFactory(updateEstablishmentService);

        UpdateEstablishmentController controller = factory.makeUpdateEstablishmentController();

        Assertions.assertNotNull(controller);
    }
}

