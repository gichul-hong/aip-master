package com.sec.aip.aipmaster.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "project")
@EnableJpaRepositories
@NoArgsConstructor
@AllArgsConstructor
public class AipProject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;
    private String projectName;
    private String namespace;
    private String description;
    
 
    @JsonIgnore
    @OneToMany(mappedBy = "project")
    private List<ProjectUser> projectUser = new ArrayList<>();
}
