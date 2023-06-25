package com.akiyaaa.JobSeekServerApp.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "application")
public class Application {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "application_id")
  private long id;

  @Column(name = "resume")
  private String resume;

  @Column(name = "date_applied")
  @DateTimeFormat(pattern = "dd-MM-yyyy")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate date;

  @ManyToOne
  @JoinColumn(name = "status_id", nullable = false)
  private Status status;

  @ManyToOne
  @JoinColumn(name = "job_id", nullable = false)
  private Job job;

  @ManyToOne
  @JoinColumn(name = "applicant_id", nullable = false)
  private Applicant applicant;
}
