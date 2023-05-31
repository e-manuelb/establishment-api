package br.com.ecb.establishmentapi.main.factories.controllers.aws;

import br.com.ecb.establishmentapi.application.controllers.aws.UploadFileController;
import br.com.ecb.establishmentapi.domain.features.aws.UploadFile;
import br.com.ecb.establishmentapi.main.factories.controllers.aws.UploadFileControllerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UploadFileControllerFactoryTest {
    @Test
    public void testMakeUploadFileController() {
        UploadFile uploadFileService = Mockito.mock(UploadFile.class);

        UploadFileControllerFactory factory = new UploadFileControllerFactory(uploadFileService);

        UploadFileController controller = factory.makeUploadFileController();

        Assertions.assertNotNull(controller);
    }
}
