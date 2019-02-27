package com.holidaysomething.holidaysomething.service.fileupload;

import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;

public interface ImageStreamService {
    String save(MultipartFile multipartFiles, Long productId);
    void readAndWrite(String saveFileName, OutputStream out);
}
