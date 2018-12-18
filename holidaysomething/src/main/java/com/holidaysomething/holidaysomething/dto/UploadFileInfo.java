package com.holidaysomething.holidaysomething.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UploadFileInfo {

  private String description;
  private MultipartFile[] fileDatas;
}
