package br.com.ecb.establishmentapi.main.factories.controllers.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.SaveEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.SaveEstablishment;
import br.com.ecb.establishmentapi.main.factories.controllers.establishment.SaveEstablishmentControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SaveEstablishmentControllerFactoryTest {

    @Test
    public void testMakeSaveEstablishmentController() {
        SaveEstablishment saveEstablishmentService = Mockito.mock(SaveEstablishment.class);

        SaveEstablishmentControllerFactory factory = new SaveEstablishmentControllerFactory(saveEstablishmentService);

        SaveEstablishmentController controller = factory.makeSaveEstablishmentController();

        Assertions.assertNotNull(controller);
    }
}

