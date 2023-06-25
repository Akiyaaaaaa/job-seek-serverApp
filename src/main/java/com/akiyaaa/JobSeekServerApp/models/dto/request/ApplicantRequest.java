package com.akiyaaa.JobSeekServerApp.models.dto.request;

import lombok.Data;

@Data
public class ApplicantRequest {
  private String firstName;
  private String lastName;
  private String phone;
  private String skill;
  private String study;
  private String experience;
}
