package com.holidaysomething.holidaysomething.util;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface FileUtil {
    ProductImage handleFileStream(HttpServletRequest request, HttpSession session, MultipartFile file);
}
