package com.akiyaaa.JobSeekServerApp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job")
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "job_id")
  private long id;

  @Column(name = "title", nullable = false, length = 40)
  private String title;

  @Column(name = "description", nullable = false, columnDefinition = "MEDIUMTEXT")
  private String desc;

  @Column(name = "requirement", nullable = false, columnDefinition = "MEDIUMTEXT")
  private String req;

  @Column(name = "qualification", nullable = false, columnDefinition = "MEDIUMTEXT")
  private String qual;

  @Column(name = "employment_type", nullable = false, length = 40)
  private String type;

  @Column(name = "employee_level", nullable = false, length = 40)
  private String level;

  @Column(name = "salary", nullable = false)
  private Float salary;

  @ManyToOne
  @JoinColumn(name = "company_id", nullable = false)
  private Company company;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  @OneToMany(mappedBy = "job")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<Application> applications;
}
