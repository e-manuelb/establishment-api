package br.com.ecb.establishmentapi.main.routes.aws;

import br.com.ecb.establishmentapi.domain.features.aws.UploadFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/upload")
public class UploadFileRoute {
    private UploadFile uploadFileService;

    public UploadFileRoute(UploadFile uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @PostMapping("/")
    public Map<String, String> uploadFile(@RequestParam(value = "file") MultipartFile file) throws FileNotFoundException {
        URL fileUrl = uploadFileService.perform(file);

        Map<String, String> message = new HashMap<>();

        message.put("fileUrl", String.valueOf(fileUrl));

        return message;
    }
}
