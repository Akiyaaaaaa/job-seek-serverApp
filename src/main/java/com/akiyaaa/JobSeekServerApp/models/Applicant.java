package com.akiyaaa.JobSeekServerApp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applicant")
public class Applicant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "applicant_id")
  private long id;

  @Column(name = "first_name", nullable = false, length = 25)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 25)
  private String lastName;

  // @Column(name = "email", unique = true)
  // private String email;

  @Column(name = "phone", unique = true)
  private String phone;

  @Column(name = "skill")
  private String skill;

  @Column(name = "study")
  private String study;

  @Column(name = "experience")
  private String experience;

  @OneToMany(mappedBy = "applicant")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<Application> applications;

  @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private User user;
}
