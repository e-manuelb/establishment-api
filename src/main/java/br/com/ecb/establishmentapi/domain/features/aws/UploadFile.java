package br.com.ecb.establishmentapi.domain.features.aws;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public interface UploadFile {
    URL perform(MultipartFile file) throws FileNotFoundException;
}
