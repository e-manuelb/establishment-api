package br.com.ecb.establishmentapi.data.services.aws;

import br.com.ecb.establishmentapi.domain.features.aws.UploadFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

@Slf4j
public class UploadFileService implements UploadFile {
    @Value("${application.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 amazonS3;

    public URL perform(MultipartFile file) throws FileNotFoundException {
        File convertedFile = convertMultipartFileToFile(file);
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        amazonS3.putObject(new PutObjectRequest(bucketName, filename, convertedFile));

        URL fileUrl = amazonS3.getUrl(bucketName, filename);

        convertedFile.delete();

        return fileUrl;
    }

    private File convertMultipartFileToFile(MultipartFile file) throws FileNotFoundException {
        File convertedFile = new File(file.getOriginalFilename());

        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException exception) {
            log.error("Error converting MultipartFile to File.", exception);
        }

        return convertedFile;
    }
}
