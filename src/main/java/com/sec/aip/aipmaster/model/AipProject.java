package com.sec.aip.aipmaster.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table
@EnableJpaRepositories
@AllArgsConstructor
@NoArgsConstructor
public class AipProject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;
    private String projectName;
    private String namespace;
    private String description;
    
   
}
