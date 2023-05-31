package br.com.ecb.establishmentapi.main.routes.establishmentEmployee;

import br.com.ecb.establishmentapi.application.controllers.establishmentEmployee.DeleteEstablishmentEmployeeByIdController;
import br.com.ecb.establishmentapi.domain.features.establishmentEmployee.DeleteEstablishmentEmployeeById;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteEstablishmentEmployeeByIdRouteTest {

    @Test
    public void testPerform() {
        DeleteEstablishmentEmployeeByIdController deleteEstablishmentEmployeeByIdController = Mockito.mock(DeleteEstablishmentEmployeeByIdController.class);
        DeleteEstablishmentEmployeeById deleteEstablishmentEmployeeByIdService = Mockito.mock(DeleteEstablishmentEmployeeById.class);
        DeleteEstablishmentEmployeeByIdRoute deleteEstablishmentEmployeeByIdRoute = new DeleteEstablishmentEmployeeByIdRoute(deleteEstablishmentEmployeeByIdService);

        BigInteger employeeId = BigInteger.valueOf(1);

        Map<String, String> result = deleteEstablishmentEmployeeByIdRoute.perform(employeeId);

        assertThat(result).isNotNull();
        assertThat(result.get("message")).isEqualTo("Establishment Employee with ID #1 was deleted successfully.");
    }
}
