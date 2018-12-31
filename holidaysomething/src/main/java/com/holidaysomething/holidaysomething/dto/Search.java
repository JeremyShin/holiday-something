package com.holidaysomething.holidaysomething.dto;

import lombok.Data;

@Data
public class Search {

  private String searchType;
  private String keyword;

  public boolean isSearched() {
    if (searchType == null || searchType.isEmpty()) {
      return false;
    }
    if (keyword == null || keyword.isEmpty()) {
      return false;
    }
    return true;
  }
}
