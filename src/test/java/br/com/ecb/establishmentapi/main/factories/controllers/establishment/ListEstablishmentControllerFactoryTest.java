package br.com.ecb.establishmentapi.main.factories.controllers.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.ListEstablishmentController;
import br.com.ecb.establishmentapi.domain.features.establishment.ListEstablishment;
import br.com.ecb.establishmentapi.main.factories.controllers.establishment.ListEstablishmentControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListEstablishmentControllerFactoryTest {

    @Test
    public void testMakeListEstablishmentController() {
        ListEstablishment listEstablishmentService = Mockito.mock(ListEstablishment.class);

        ListEstablishmentControllerFactory factory = new ListEstablishmentControllerFactory(listEstablishmentService);

        ListEstablishmentController controller = factory.makeListEstablishmentController();

        Assertions.assertNotNull(controller);
    }
}

