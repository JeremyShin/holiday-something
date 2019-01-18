package com.holidaysomething.holidaysomething.service.fileupload;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Profile("real")
@Service
@Slf4j
@RequiredArgsConstructor
public class S3ImageStreamServiceImpl implements ImageStreamService{

    private final ProductRepository productRepository;
    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.bucket.dirName}")
    private String dirName;

    @Override
    public void save(MultipartFile[] multipartFiles) {
        for(MultipartFile multipartFile : multipartFiles) {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(multipartFile.getContentType());
            objectMetadata.setContentLength(multipartFile.getSize());
            String fileKey = dirName + "/t/" + UUID.randomUUID();
            try {
                amazonS3Client.putObject(bucket, fileKey, multipartFile.getInputStream(), objectMetadata);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            return amazonS3Client.getUrl(bucket, fileKey).toString();
        }
    }
}
