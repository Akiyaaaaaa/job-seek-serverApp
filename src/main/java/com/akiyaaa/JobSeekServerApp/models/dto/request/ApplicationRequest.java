package com.akiyaaa.JobSeekServerApp.models.dto.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ApplicationRequest {
  private String resume;
  @DateTimeFormat(pattern = "dd-MM-yyyy")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate date;
  private Long statusId;
  private Long jobId;
  private Long applicantId;
}
