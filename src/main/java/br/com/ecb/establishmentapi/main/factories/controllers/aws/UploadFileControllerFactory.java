package br.com.ecb.establishmentapi.main.factories.controllers.aws;

import br.com.ecb.establishmentapi.application.controllers.aws.UploadFileController;
import br.com.ecb.establishmentapi.domain.features.aws.UploadFile;

public class UploadFileControllerFactory {
    private UploadFile uploadFileService;

    public UploadFileControllerFactory(UploadFile uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    public UploadFileController makeUploadFileController() {
        return new UploadFileController(uploadFileService);
    }
}
