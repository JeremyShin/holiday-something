package com.holidaysomething.holidaysomething.util;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FileUtilImpl implements FileUtil {
    @Override
    public ProductImage handleFileStream(HttpServletRequest request, HttpSession session, MultipartFile files) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr = simpleDateFormat.format(new Date());
        String baseDir = request.getSession().getServletContext().getRealPath("/src/main/resources/uploadFiles");  // 해당 경로로 파일 업로드
        String saveDir = baseDir + "/" + dateStr;
        String storedFileName = UUIDGenerator.getRandomString();
        String path = saveDir + "/" + storedFileName;

        File file = new File(saveDir);
        file.mkdir();

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
            inputStream = files.getInputStream();
            outputStream = new FileOutputStream(path);
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, readCount);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(inputStream != null){
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                try{
                    outputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            } // if
        } // finally

        ProductImage productImageFileInfo = new ProductImage();
        productImageFileInfo.setOriginalFileName(files.getOriginalFilename());
        productImageFileInfo.setStoredFileName(storedFileName);
        productImageFileInfo.setPath(path);
        productImageFileInfo.setSize(files.getSize());
        productImageFileInfo.setFileType(files.getContentType());
        return productImageFileInfo;
    }
}
