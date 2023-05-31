package br.com.ecb.establishmentapi.main.routes.establishment;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.ecb.establishmentapi.application.controllers.establishment.DeleteEstablishmentByIdController;
import br.com.ecb.establishmentapi.domain.features.establishment.DeleteEstablishmentById;

import java.math.BigInteger;
import java.util.Map;

public class DeleteEstablishmentByIdRouteTest {

    @Test
    public void testPerform() {
        DeleteEstablishmentByIdController deleteEstablishmentByIdController = Mockito.mock(DeleteEstablishmentByIdController.class);
        DeleteEstablishmentById deleteEstablishmentByIdService = Mockito.mock(DeleteEstablishmentById.class);
        DeleteEstablishmentByIdRoute deleteEstablishmentByIdRoute = new DeleteEstablishmentByIdRoute(deleteEstablishmentByIdService);

        BigInteger establishmentId = BigInteger.valueOf(1);

        doNothing().when(deleteEstablishmentByIdController).perform(establishmentId);

        Map<String, String> result = deleteEstablishmentByIdRoute.perform(establishmentId);

        assertThat(result).isNotNull();
        assertThat(result.get("message")).isEqualTo("Establishment with ID #" + establishmentId + " was deleted successfully.");
    }
}

