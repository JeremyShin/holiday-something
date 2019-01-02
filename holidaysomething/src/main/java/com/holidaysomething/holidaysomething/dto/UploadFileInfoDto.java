package com.holidaysomething.holidaysomething.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadFileInfoDto {

  private String description;
  private MultipartFile[] fileDatas;
}
