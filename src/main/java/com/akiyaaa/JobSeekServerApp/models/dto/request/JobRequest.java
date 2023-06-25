package com.akiyaaa.JobSeekServerApp.models.dto.request;

import lombok.Data;

@Data
public class JobRequest {
  private String title;
  private String desc;
  private String req;
  private String qual;
  private String type;
  private String level;
  private float salary;
  private Long companyId;
  private Long categoryId;
}
