package com.akiyaaa.JobSeekServerApp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "status")
public class Status {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "status_id")
  private long id;

  @Column(name = "status_name", nullable = false, length = 40)
  private String name;

  @OneToMany(mappedBy = "status")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<Application> applications;
}
