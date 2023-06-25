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
@Table(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "category_id")
  private long id;

  @Column(name = "category_name", nullable = false, length = 225)
  private String name;

  @OneToMany(mappedBy = "category")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<Job> jobs;
}
