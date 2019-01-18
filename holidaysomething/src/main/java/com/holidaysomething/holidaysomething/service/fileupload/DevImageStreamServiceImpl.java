package com.holidaysomething.holidaysomething.service.fileupload;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.UUID;

@Profile("local")
@Service
@Slf4j
@RequiredArgsConstructor
public class DevImageStreamServiceImpl implements ImageStreamService {

    private final ProductRepository productRepository;

    // Linux: /home/{user}/test
    private static String fileUploadDir = System.getProperty("user.home") + "/test/";

    @Override
    @Transactional
    public void save(MultipartFile[] multipartFiles) {


        Calendar cal = Calendar.getInstance();
        String path = fileUploadDir + cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH) + cal.get(Calendar.DAY_OF_MONTH) + "/";
        File uploadDir = new File(path);
        uploadDir.mkdirs();

        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.getOriginalFilename().isEmpty()) {

                log.info("======Save Start!!========");
                log.info(multipartFile.getName());
                log.info("==========================");

                String storedFileName = UUID.randomUUID().toString();

                try (
                        InputStream in = multipartFile.getInputStream();
                        OutputStream out = new FileOutputStream(path + storedFileName)
                ) {
                    byte[] buffer = new byte[1024];
                    int readCount = 0;
                    while ((readCount = in.read(buffer)) != -1) {
                        out.write(buffer, 0, readCount);
                    }
                } catch (IOException ioe) {
                    throw new RuntimeException(ioe.getMessage());
                }

                ProductImage productImage = new ProductImage();
                productImage.setOriginalFileName(multipartFile.getOriginalFilename());
                productImage.setFileType(multipartFile.getContentType());
                productImage.setPath(path);
                productImage.setStoredFileName(storedFileName);
                productImage.setRegDate(LocalDateTime.now());
                productImage.setSize(multipartFile.getSize());

                // Category 1 = Main Image
                // Category 2 = Description Image
                if (multipartFile.getName().equals("mainImages")) {
                    productImage.setCategory(1L);
                } else
                    productImage.setCategory(2L);

                productRepository.save(productImage);
            }
        }
    }
}
