package com.holidaysomething.holidaysomething.service.fileupload;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import org.springframework.web.multipart.MultipartFile;

public interface ImageStreamService {
    public void save(MultipartFile multipartFile);
//    public void readAndWrite(String saveFileName, OutputStream out);
}
