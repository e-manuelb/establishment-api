package br.com.ecb.establishmentapi.main.config.beans.aws;

import br.com.ecb.establishmentapi.data.services.aws.UploadFileService;
import br.com.ecb.establishmentapi.domain.features.aws.UploadFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadFileBean {

    @Bean
    public UploadFile uploadFile() {
        return new UploadFileService();
    }
}
