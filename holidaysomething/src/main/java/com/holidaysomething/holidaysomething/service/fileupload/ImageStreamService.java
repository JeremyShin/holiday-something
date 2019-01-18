package com.holidaysomething.holidaysomething.service.fileupload;

import org.springframework.web.multipart.MultipartFile;

public interface ImageStreamService {
    public void save(MultipartFile[] multipartFiles);
//    public void readAndWrite(String saveFileName, OutputStream out);
}
