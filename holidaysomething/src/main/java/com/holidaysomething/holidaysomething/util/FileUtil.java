package com.holidaysomething.holidaysomething.util;

import com.holidaysomething.holidaysomething.domain.ProductImage;
import com.holidaysomething.holidaysomething.service.ProductService;
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
public class FileUtil {

    public ProductImage handleFileStream(HttpServletRequest request, HttpSession session, MultipartFile file){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr = simpleDateFormat.format(new Date());
        String baseDir = request.getSession().getServletContext().getRealPath("/"); // 현재 경로로 파일 업로드
        String saveDir = baseDir + "/" + dateStr;
        String saveFile = saveDir + "/" + UUIDGenerator.getRandomString();

        File file1 = new File(saveDir);
        file1.mkdirs();

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try{
            inputStream = file.getInputStream();
            outputStream = new FileOutputStream(saveFile);
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
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try {
                    outputStream.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }

        ProductImage productImage = new ProductImage();
        productImage.setOriginalFileName(file.getOriginalFilename());
        productImage.setStoredFileName(saveFile);
        productImage.setSize(file.getSize());
        productImage.setFileType(file.getContentType());

        return productImage;
    }
}
