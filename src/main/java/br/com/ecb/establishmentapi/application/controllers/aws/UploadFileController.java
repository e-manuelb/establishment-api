package br.com.ecb.establishmentapi.application.controllers.aws;

import br.com.ecb.establishmentapi.domain.features.aws.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.net.URL;

public class UploadFileController {
    private UploadFile uploadFileService;

    public UploadFileController(UploadFile uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    public URL perform(MultipartFile file) throws FileNotFoundException {
        return uploadFileService.perform(file);
    }
}
