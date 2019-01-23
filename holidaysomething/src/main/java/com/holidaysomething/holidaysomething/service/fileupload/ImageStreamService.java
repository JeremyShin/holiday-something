package com.holidaysomething.holidaysomething.service.fileupload;

import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;

public interface ImageStreamService {
    public String save(MultipartFile multipartFiles, Long productId);
    public void readAndWrite(String saveFileName, OutputStream out);
}
