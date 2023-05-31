package br.com.ecb.establishmentapi.main.routes.aws;

import br.com.ecb.establishmentapi.domain.features.aws.UploadFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class UploadFileRouteTest {

    @Test
    public void testUploadFile() throws FileNotFoundException, MalformedURLException {
        UploadFile uploadFileService = Mockito.mock(UploadFile.class);

        UploadFileRoute uploadFileRoute = new UploadFileRoute(uploadFileService);

        MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "Test file".getBytes());

        URL mockFileUrl = new URL("https://example.com/test.txt");
        Mockito.when(uploadFileService.perform(file)).thenReturn(mockFileUrl);

        Map<String, String> result = uploadFileRoute.uploadFile(file);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(mockFileUrl.toString(), result.get("fileUrl"));
    }
}

