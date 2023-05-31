package br.com.ecb.establishmentapi.main.factories.controllers.establishment;

import br.com.ecb.establishmentapi.application.controllers.establishment.DeleteEstablishmentByIdController;
import br.com.ecb.establishmentapi.domain.features.establishment.DeleteEstablishmentById;
import br.com.ecb.establishmentapi.main.factories.controllers.establishment.DeleteEstablishmentByIdControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DeleteEstablishmentByIdControllerFactoryTest {

    @Test
    public void testMakeDeleteEstablishmentByIdController() {
        DeleteEstablishmentById deleteEstablishmentByIdService = Mockito.mock(DeleteEstablishmentById.class);

        DeleteEstablishmentByIdControllerFactory factory = new DeleteEstablishmentByIdControllerFactory(deleteEstablishmentByIdService);

        DeleteEstablishmentByIdController controller = factory.makeDeleteEstablishmentByIdController();

        Assertions.assertNotNull(controller);
    }
}


