package br.com.ecb.establishmentapi.main.factories.controllers.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.FindEstablishmentByIdController;
import br.com.ecb.establishmentapi.domain.features.establishment.FindEstablishmentById;
import br.com.ecb.establishmentapi.main.factories.controllers.establishment.FindEstablishmentByIdControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FindEstablishmentByIdControllerFactoryTest {

    @Test
    public void testMakeFindEstablishmentByIdController() {
        FindEstablishmentById findEstablishmentByIdService = Mockito.mock(FindEstablishmentById.class);

        FindEstablishmentByIdControllerFactory factory = new FindEstablishmentByIdControllerFactory(findEstablishmentByIdService);

        FindEstablishmentByIdController controller = factory.makeFindEstablishmentByIdController();

        Assertions.assertNotNull(controller);
    }
}
