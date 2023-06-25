package com.akiyaaa.JobSeekServerApp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "company")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "company_id")
  private long id;

  @Column(name = "company_name", nullable = false, length = 225)
  private String name;

  @Column(name = "company_industry", nullable = false, length = 50)
  private String industry;

  @Column(name = "company_website", length = 225)
  private String website;

  @Column(name = "company_address", length = 225)
  private String address;

  @ManyToOne
  @JoinColumn(name = "country_id", nullable = false)
  private Country country;

  @OneToMany(mappedBy = "company")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<Job> jobs;

  @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private User user;
}
