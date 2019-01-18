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

// 개발 환경에서 S3와의 연동을 테스트할 때에도 사용할 수 있음, TODO ** S3 용량 5G 넘으면 과금입니다!!! **
// program arguments 에 --spring.profiles.active=real 로 설정하여 구동하면 됩니다.
// 또는 VM options 에 -Dspring.profiles.active=real 로 설정하여 구동하면 됩니다.
// VM options 보다 program arguments 의 우선순위가 더 높기 때문에 둘을 다르게 설정하면 program arguments 의 설정으로 구동됩니다.
@Profile("real")
@Service
@Slf4j
@RequiredArgsConstructor
public class S3ImageStreamServiceImpl implements ImageStreamService{

    private final ProductRepository productRepository;
    private final AmazonS3Client amazonS3Client;

    // S3 버킷의 이름
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    // 파일을 업로드 할 폴더 이름
    @Value("${cloud.aws.s3.bucket.dirName}")
    private String dirName;

    @Override
    public void save(MultipartFile[] multipartFiles) {
        for(MultipartFile multipartFile : multipartFiles) {
            // 멀티플 업로드를 설정하면 파일을 올리지 않아도 쓰레기 파일이 날라와서 걸러내기 위함...
            if (!multipartFile.getOriginalFilename().isEmpty()) {
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentType(multipartFile.getContentType());
                objectMetadata.setContentLength(multipartFile.getSize());

                // 일단 해당 폴더 이하에서만 파일을 읽을 수 있도록 있도록 권한을 설정하였음.(다른 곳에 올리면 못 읽어요!!)
                // 근데 다른 곳에 올릴 수는 있어요...
                String path = dirName + "/images";
                String storedFileName = UUID.randomUUID().toString();

                String fileKey = path + "/" + storedFileName;

                try {
                    amazonS3Client.putObject(bucket, fileKey, multipartFile.getInputStream(), objectMetadata);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String s = amazonS3Client.getUrl(bucket, fileKey).toString();
            }
        }
    }
}
