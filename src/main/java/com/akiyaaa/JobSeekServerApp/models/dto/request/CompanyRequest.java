package com.akiyaaa.JobSeekServerApp.models.dto.request;

import lombok.Data;

@Data
public class CompanyRequest {
  private String name;
  private String industry;
  private String website;
  private String address;
  private Long countryId;
}
