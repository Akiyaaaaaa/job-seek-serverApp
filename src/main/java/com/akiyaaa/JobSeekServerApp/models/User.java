package com.akiyaaa.JobSeekServerApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private long id;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "password", nullable = false, length = 25)
  private String password;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  private Boolean isEnabled = true;
  private Boolean isAccountNonLocked = true;

  @OneToOne
  @MapsId
  @JoinColumn(name = "applicant_id")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Applicant applicant;

  @OneToOne
  @MapsId
  @JoinColumn(name = "company_id")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Company company;
}
