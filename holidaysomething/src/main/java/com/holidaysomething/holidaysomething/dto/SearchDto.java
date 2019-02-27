package com.holidaysomething.holidaysomething.dto;

import lombok.Data;

@Data
public class SearchDto {

  private String searchType;
  private String keyword;

  public boolean isSearched() {
    if (searchType == null || searchType.isEmpty()) {
      return false;
    }
    return keyword != null && !keyword.isEmpty();
  }
}
